# Documentação da API do Projeto Quinze
Esta é a documentação da API para o projeto Quinze, que permite gerar combinações de números entre 1 e 60, 
retornando 6 números dentre aqueles, de forma aleatória.

## Endpoints da API

#### Gerar Combinação
_Endpoint_ para gerar uma nova combinação de números.

- **URL: `/api/v1/combinations/generate`**
- **Método: `POST`**

Resposta de exemplo:
```json
{
  "id": 1,
  "data": "2023-08-12T06:43:56.959307",
  "numero1": 19,
  "numero2": 15,
  "numero3": 44,
  "numero4": 20,
  "numero5": 12,
  "numero6": 1
}
```

#### Listar todas as combinações
_Endpoint_ para listar todas as combinações geradas.

- **URL: `/api/v1/combinations/all`**
- **Método: `GET`**

Resposta de exemplo:
```json
[
  {
    "id": 1,
    "data": "2023-08-12T06:43:56.959307",
    "numero1": 19,
    "numero2": 15,
    "numero3": 44,
    "numero4": 20,
    "numero5": 12,
    "numero6": 1
  },
  {
    "id": 2,
    "data": "2023-08-12T06:46:37.805553",
    "numero1": 22,
    "numero2": 49,
    "numero3": 48,
    "numero4": 19,
    "numero5": 13,
    "numero6": 14
  }
]
```

