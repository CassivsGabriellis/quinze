# Documentação da API do Projeto Quinze
Esta é a documentação da API para o projeto Quinze, que permite gerar combinações de números entre 1 e 25, 
retornando 15 números dentre aqueles de forma aleatória.

## Endpoints da API

#### Gera uma nova combinação:

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

#### Lista todas as combinações geradas:

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

#### Lista a frequência de saída de cada um dos números:

- **URL: `/api/v1/combinations/statistics/number-frequency`**
- **Método: `GET`**

Resposta de exemplo:
```json
{
  "numero1": 7,
  "numero2": 5,
  "numero3": 5,
  "numero4": 4,
  "numero5": 5,
  "numero6": 6,
  "numero7": 7,
  "numero8": 3,
  "numero9": 3,
  "numero10": 5,
  "numero11": 6,
  "numero12": 8,
  "numero13": 6,
  "numero14": 6,
  "numero15": 6,
  "numero16": 5,
  "numero17": 9,
  "numero18": 6,
  "numero19": 7,
  "numero20": 8,
  "numero21": 6,
  "numero22": 6,
  "numero23": 7,
  "numero24": 9,
  "numero25": 5
}
```

