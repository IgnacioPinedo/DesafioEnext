# DesafioEnext

## Como Rodar

Para rodar o parser basta rodar o método main do arquivo Main.

## Explicação

Nele é buscado o arquivo de log em uma pasta na raiz do solução e em seguinda ele é parseado. Depois o programa verifica todas as linas procurando por mortes e assim adicionando elas (e também as armas) para uma variável game para cada jogo, assim que o jogo é finalizado essa variável game é armezenada numa lista para no final ser exibida no console. No final a lista de jogos é exibida no console (também é exibido o console as armas e quantas mortes cada uma teve).

## API

A API foi publicada na seguinte URL [DesafioEnext](https://desafioenext.azurewebsites.net/)

#### É possível buscar:

```
- Todos os jogos: URL + Games
- Jogos por Id: URL + Games(Id)
- Jogos por Hash: URL + GamesByHash(Hash)
```
