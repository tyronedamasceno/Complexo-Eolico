# Documentação

A API está rodando no *heroku* e sua URL base é:

Para usar o sistema, certifique-se de ter suas credenciais em mãos.

## Endpoints

- /login
    - **POST** - Esta requisição gera um token de acesso para os demais endpoints da API. O token é disponibilizado no cabeçalho *authorization* da resposta da requisição. A requisição requer um corpo com os seguintes atributos:
        - *username* : string
        - *password* : string

-  /complexos
    -  **GET** - Retorna uma resposta com todos os Complexos Eólicos cadastrados no sistema.
    -  **POST** - Cadastra um novo Complexo Eólico no sistema. A requisição requer um corpo com os seguintes atributos:
        -  *name* : string
        -  *uf* : string
        -  *identificador* : string

-  /complexos/id
    -  **GET** - Retorna os detalhes do Complexo Eólico com o *id* especificado
    -  **PUT** - Atualiza as informações do Complexo Eólico com o *id* especificado. Esta requisição aceita um corpo com os seguintes atributos:
        -  *nome* : string
        -  *uf* : string
        -  *identificador* : string
    -  **DELETE** - Remove do sistema o Complexo Eólico com o *id* especificado.

-  /complexos/id/parques
    -  **GET** - Retorna uma lista com todos os Parques Eólicos pertencentes ao Complexo Eólico com o *id* especificado.

-  /parques
    -  **GET** - Retorna uma resposta com todos os Parques Eólicos cadastrados no sistema.
    -  **POST** - Cadastra um novo Parque Eólico no sistema. A requisição requer um corpo com os seguintes atributos:
        -  *nome* : string
        -  *latitude* : string
        -  *longitude* : string
        -  *potenciaInstalada* : float
        -  *complexo* : 
            - *id* : integer

-  /parques/id
    -  **GET** - Retorna os detalhes do Parque Eólico com o *id* especificado
    -  **PUT** - Atualiza as informações do Parque Eólico com o *id* especificado. Esta requisição aceita um corpo com os seguintes atributos:
        -  *nome* : string
        -  *latitude* : string
        -  *longitude* : string
        -  *potenciaInstalada* : float
        -  *complexo* : 
            - *id* : integer
    -  **DELETE** - Remove do sistema o Parque Eólico com o *id* especificado.

-  /parques/id/aerogeradores
    -  **GET** - Retorna uma lista com todos os Aerogeradores pertencentes ao Parque Eólico com o *id* especificado.

-  /aerogeradores
    -  **GET** - Retorna uma resposta com todos os Aerogeradores cadastrados no sistema.
    -  **POST** - Cadastra um novo Aerogeradores no sistema. A requisição requer um corpo com os seguintes atributos:
        -  *nome* : string
        -  *latitude* : float
        -  *longitude* : float
        -  *alturaTorre* : float
        -  *diametroVarredura* : float
        -  *modelo* : string
        -  *parque* : 
            - *id* : integer

-  /parques/id
    -  **GET** - Retorna os detalhes do Aerogerador com o *id* especificado
    -  **PUT** - Atualiza as informações do Aerogerador com o *id* especificado. Esta requisição aceita um corpo com os seguintes atributos:
        -  *nome* : string
        -  *latitude* : float
        -  *longitude* : float
        -  *alturaTorre* : float
        -  *diametroVarredura* : float
        -  *modelo* : string
        -  *parque* : 
            - *id* : integer
    -  **DELETE** - Remove do sistema o Aerogerador com o *id* especificado.

## Informações adicionais

-  O token gerado após a requisição feita para o endpoint */login* deve ser passado como cabeçalho *"Authorization"* de todas as outras requisições
