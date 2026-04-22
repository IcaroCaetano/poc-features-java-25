

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

- Blocking sem custo alto

- Scoped Values

- 