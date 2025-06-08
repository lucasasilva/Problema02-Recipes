Problema 02:  Criar uma API que receba um um prato e retorne a lista de receitas encontradas.
 As receitas devem ser consultadas na API https://forkify-api.herokuapp.com/api/ passando o prato como 
parâmetro.

Todas as dependências estão no pom.xml

Métodos: 

/recipes/searchAll?recipe={String}
Método: GET
Descrição: Retorna todas as receitas encontradas para String passada no argumento.

/recipes/searchById?recipeId={Integer}
Método: GET
DescriçãoL Retorna a receita encontrada para o número passado no argumento;
