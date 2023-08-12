# Documentação da API do Projeto Quinze
Esta é a documentação da API para o projeto Quinze, que permite gerar combinações de números entre 1 e 25, 
retornando 15 números dentre aqueles de forma aleatória.

## Endpoints da API

#### Gerar Combinação
_Endpoint_ para gerar uma nova combinação de números.

- **URL: `/api/v1/combinations/generate`**
- **Método: `POST`**

Resposta de exemplo:
```json
{
  "id": 1,
  "data": "2023-08-12T17:05:21.644895",
  "numeros": {
    "numero1": 24,
    "numero2": 18,
    "numero3": 4,
    "numero4": 3,
    "numero5": 22,
    "numero6": 5,
    "numero7": 6,
    "numero8": 16,
    "numero9": 19,
    "numero10": 12,
    "numero11": 25,
    "numero12": 9,
    "numero13": 2,
    "numero14": 10,
    "numero15": 23
  }
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
    "data": "2023-08-12T17:05:21.644895",
    "numeros": {
      "numero1": 24,
      "numero2": 18,
      "numero3": 4,
      "numero4": 3,
      "numero5": 22,
      "numero6": 5,
      "numero7": 6,
      "numero8": 16,
      "numero9": 19,
      "numero10": 12,
      "numero11": 25,
      "numero12": 9,
      "numero13": 2,
      "numero14": 10,
      "numero15": 23
    }
  },
  {
    "id": 2,
    "data": "2023-08-12T17:05:22.98191",
    "numeros": {
      "numero1": 4,
      "numero2": 15,
      "numero3": 17,
      "numero4": 12,
      "numero5": 25,
      "numero6": 1,
      "numero7": 18,
      "numero8": 22,
      "numero9": 7,
      "numero10": 16,
      "numero11": 8,
      "numero12": 10,
      "numero13": 24,
      "numero14": 11,
      "numero15": 21
    }
  }
  // Etc
]
```

