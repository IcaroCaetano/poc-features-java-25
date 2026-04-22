

## Features

- Virtual Threads

Virtual Threads são threads leves gerenciadas pela JVM, não pelo sistema operacional.

    - Threads leves (lightweight)
    - Escalabilidade massiva


⚙️ Comparação essencial

------------------------------------------------------------------------------
|Tipo de Thread-----|---Quem gerencia------|----Custo-----|----Escalabilidade-|

|-----------------------------------------------------------------------------|

|Platform Thread----|--Sistema Operaciona--|--Alto--------|----Baixa----------|

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

- Blocking sem custo alto

- Scoped Values

- 