- Mockk

- Características principais
    - comando mockk
    - Serve para criar uma instância de um mock, que quando receber uma chamada não treinada lança uma exception
    - comando every
    - Serve para mapear as respostas esperadas para as chamadas dos métodos do mock (específicas ou não)
    - every with return
    - every with answer
    - every with just runs (para metodos void)
    - every with throws
    - comando verify
    - Serve para validar que um método foi chamado, ou um determinado número de vezes
- Annotations
    - @MockK - Cria um mock
    - @InjectMockKs - Cria a instância passando os mocks
    - @SpyK - cria um spy
- JUnit5
- Usando MockKExtension

- Funcionalidades
- RelaxedMock - Relaxed mock, são mocks onde não é necessário específicar os retornos, um valor padrão é retornado, não é o ideal
- PartialMock - Partial mock, como o próprio nome diz é um mock onde parte das chamadas serão feitas na classe original e partes serão funções stub
- Spy - (spyk) Spy é utilizado quando precisamos mesclar mocks coms os objetos reais (Permite utilizar o verify nesses objetos e o every)
- Capturing - É uma funcionalidade utilizada para obter um valor a partir de uma chamada que é mockada
- Mockando funções privadas - Utilizando o spyk passando o parâmetro recordPrivateCalls = true, permite utilizar o every mockando as chamadas à métodos privados

- Spies, mockkStatic may not work on JDK 16+;