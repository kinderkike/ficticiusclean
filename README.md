# Ficticius Clean
Ficticius Clean - Entrega de produtos de limpeza.

Foram utilizados as seguintes tecnologias
- Java 11
- Spring boot 2.7.1
- Banco de dados H2
- Flyway
- Postman (Para testar a API)

# Configurar e executar (Windows)

1. Abra o **Git Bash** e acesse a pasta no seu computador onde será realizado o clone da branch
2. Utilize o seguinte comando para clonar a brach **main**:
> git clone https://github.com/kinderkike/ficticiusclean.git

3. Acesse a pasta **/ficticiusclean/** onde foi realizado o clone da branch
4. Execute o seguinte comando para executar os testes e compilar:
> ./mvnw clean install
5. Após a execução do comando o maven irá gerar pasta **/ficticiusclean/target/** com vários arquivos
6. Acesse a pasta **target** e execute o seguinte comando para iniciar a aplicação:
> java -jar ficticiusclean-0.0.1-SNAPSHOT.jar
7. Pronto, com isso a **API** já estará disponível para ser utilizada na porta **80**
8. Para testar recomendo utilizar o **Postman**
9. Abaixo as APIs disponíveis para utilização
- Para incluir um veículo:
><p> curl --location --request POST 'localhost/veiculos' \<br>
>--header 'Content-Type: application/json' \<br>
>--data-raw '{<br>
>&nbsp;&nbsp;&nbsp;"nome": "Uno",<br>
>&nbsp;&nbsp;&nbsp;"marca": "Fiat",<br>
>&nbsp;&nbsp;&nbsp;"modelo": "Sporting 1.4",<br>
>&nbsp;&nbsp;&nbsp;"anoFabricacao": 2013,<br>
>&nbsp;&nbsp;&nbsp;"consumoCidade": 10,<br>
>&nbsp;&nbsp;&nbsp;"consumoRodovia": 15<br>
>}'</p>
- Para listar veículos:
> curl --location --request GET 'localhost/veiculos'
- Para listar veículos ranqueando os mesmos considerando o valor gasto com combustível. Do custo mais barato ao mais caro:
><p>curl --location --request GET 'localhost/previsao-gastos' \<br>
>--header 'Content-Type: application/json' \<br>
>--data-raw '{<br>
>&nbsp;&nbsp;&nbsp;"precoCombustivel": 6.89,<br>
>&nbsp;&nbsp;&nbsp;"distanciaKmCidade": 8,<br>
>&nbsp;&nbsp;&nbsp;"distanciaKmRodovia": 13<br>
>}'</p>

# Observações
- O banco de dados ficará na pasta **/target/data/ficticiusclean.mv.db**
- Toda vez que iniciar o sistema é apagado os registros da base e inserido 3 veículos (Já para iniciar com veículos para testar)
- Caso queira remover os 3 registros, remover os inserts no arquivo **ficticiusclean\src\main\resources\db\initialize\afterMigrate.sql** e execute o passo **3.**
