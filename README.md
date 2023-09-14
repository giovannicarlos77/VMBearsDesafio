# VMBearsDesafio

# Instruções para Iniciar o Projeto

Para iniciar o projeto, siga as etapas abaixo:

1. Navegue até a pasta do frontend do projeto.

2. Abra um terminal na pasta do frontend.

3. Digite o seguinte comando para instalar as dependências do frontend:

   ```shell
   npm install
   ```

4. Após a conclusão da instalação, execute o comando abaixo para iniciar o servidor:
   ```shell
   ng serve
   ```
5. Servidor disponível na url:
   ```
   http://localhost:4200/
   ```
# Backend

## API 1: Processar Arquivos XML

A primeira API do backend permite que você processe arquivos XML. Você pode enviá-los usando o método HTTP POST em formato `multipart/form-data`. A URL da API é:

```
http://localhost:8080/process-xml
```

Para usar esta API, envie os arquivos XML desejados no corpo da solicitação HTTP como um formulário `multipart` e o form-data nomeada por `files`. O servidor processará os arquivos XML e fornecerá uma resposta adequada.

## API 2: Encontrar Região por Sigla

A segunda API do backend permite que você encontre informações sobre uma região, tão quanto seus respectivos dados superiores (Agente,RegiaoCompra,etc) com base em sua sigla. Esta API espera um objeto JSON como entrada e retorna informações sobre a região correspondente. A URL da API é:

```
http://localhost:8080/find-region
```

Exemplo de entrada JSON para esta API:

```json
{
    "sigla": "SE"
}
```

Este exemplo solicita informações sobre a região com a sigla "SE". Você pode substituir "SE" pela sigla desejada para obter informações sobre outras regiões.

---
