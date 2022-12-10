<h1> spring-rest</h1>
<p>Api rest usando Spring Boot com banco de dados em memória H2.<br>
Gerar venda e retornar uma lista de vendedores conforme o período informado por parâmetro </p>

<br>
<h2><strong>PARÂMETROS DE PROPRIEDADE</strong></h2>
<p>Porta do servidor | --port | 9090 </p>
<br>
<h2><strong>GET</strong></h2>
<p> /produto - Lista todos os produtos /produto/{id} - Busca um produto por id </p>
<br>
<p> /venda - Lista todos as vendas /venda/{id} - Busca uma venda por id </p>
<br>
<p> /vendedor?dataInicio=yyyy-mm-dd&dataFim=yyyy-mm-dd - Lista todos os vendedores do periodo solicitado
<br>
<h2><strong>POST</strong></h2>
<p> /vendedor - Adiciona um novo cliente </p>
<p>{ "nome": "(nome do vendedor)" }</p>
<br>
<p> /produto - Adiciona um novo produto </p>
<p>{ "descricao": "(descricao do produto)", "valor": (valor do produto) }</p>
<br>
<p> /venda - Adciona uma nova venda </p>
<p>{ "vendedorId": (id vendedor), "produtosIds": [(id produto), (id produto),...] }<p>
