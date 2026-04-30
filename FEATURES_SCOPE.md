

## Features

### Virtual Threads

Virtual Threads são threads leves gerenciadas pela JVM, não pelo sistema operacional.

    - Threads leves (lightweight)
    - Escalabilidade massiva
    - Gerenciados pela JVM


#### ⚙️ Comparação essencial

------------------------------------------------------------------------------
|Tipo de Thread-----|---Quem gerencia------|----Custo-----|----Escalabilidade-|

|-----------------------------------------------------------------------------|

|Platform Thread----|--Sistema Operacional--|--Alto--------|----Baixa----------|

|-----------------------------------------------------------------------------|

|Virtual Thread-----|--JVM-----------------|--Muito baixo-|--Altíssima--------|

------------------------------------------------------------------------------|

````java
// Cria uma Virtual para cada tarefa submetida
ExecutorService executor =  Executors.newVirtualThreadPerTaskExecutor();

// 10.000 tarefas -> 10.00 virtual threads
 IntStream.range(0, 10_000).forEach(i ->
        executor.submit(() -> {
        System.out.println("Task " + i + " -> " + Thread.currentThread());
        })
 );
````

#### Quando ela “dorme” (ex: Thread.sleep)
1. Virtual Thread A é pausada
2. Estado dela é salvo no heap (não na thread real!)
3. Carrier Thread 1 é liberada
4. JVM escolhe outra virtual thread
5. Virtual Thread B começa a rodar no mesmo carrier


Uma thread real (carrier) executa uma virtual thread por vez. Quando a virtual thread bloqueia, a JVM salva seu 
estado no heap, libera a thread real, e agenda outra virtual thread para execução.

Obs: Heap é a área de memória onde vivem os objetos criados pela JVM.

- Blocking sem custo alto

### Structured Concurrency

#### StructuredTaskScope.open()

Resolve o problema de desorganização. As threads iniciam, executam, fecha
e tudo termina junto. De forma organizada e estruturada. Pois elas vivem dentro 
de um unico bloco.

- foi criado para organizar concorrência
- evita vazamento de threads
- centraliza controle
- melhora legibilidade
- torna o comportamento previsível

#### scope.fork(..)

1. Você chama fork()
2. A JVM cria uma Virtual Thread
3. Essa Virtual Thread executa sua função (fetchUser)
4. O resultado/erro é armazenado no Subtask


E quando a tarefa bloqueia?
Virtual Thread pausa
→ JVM salva estado no heap
→ libera carrier thread
→ outra virtual thread executa

Subtask = um “handle” (controle) de uma tarefa concorrente

Subtask
├── referência da execução (virtual thread)
├── estado da tarefa
├── resultado (quando terminar)
└── erro (se falhar)


A Subtask existe pra você poder:
Pegar o resultado

````java
user.get();
````

Saber o estado

````java
user.state();
````

Exemp:

SUCCESS
FAILED
RUNNING

##### 🧠 Insight importante

👉 A Subtask NÃO é a thread
👉 NÃO é a execução

Ela é:

o objeto que te permite acompanhar e acessar essa execução

#### escope.join()


Bloqueia a thread atual até TODAS as subtasks terminarem
"espera todas as tarefas que eu dei fork terminarem"

````java
var user = scope.fork(this::fetchUser);
var order = scope.fork(this::fetchOrder);

scope.join();
````

````
1. você criou 2 subtasks
2. ambas estão rodando (virtual threads)
3. join() entra em espera
4. só continua quando TODAS terminarem
````

### Scoped Values

Permitem passar “contexto” implicitamente para chamadas profundas, mas de forma delimitada por escopo, previsível e segura.

Subistituiu as ThreadLocal que eram mutaveis e global por thread. E causavam vazamento de contexto.

- Imutáveis
- Limitados a um escopo bem definido
- Compatíveis com Virtual Threads e Structured Concurrency

#### 1️⃣ Contexto fica associado a um escopo, não a uma thread

Ou seja:

• existe somente dentro do bloco definido
• não pode escapar dele
• não pode ser alterado

#### 2️⃣ Binding explícito e estruturado

Você sempre declara onde o valor passa a existir:

```java
ScopedValue.where(CONTEXT, value).run(() -> {
    // aqui o valor é visível
});
```

#### 3️⃣ Imutabilidade por design

Com Scoped Values, você sempre declara onde o valor nasce.
Nada de “alguém setou isso em algum lugar”:
