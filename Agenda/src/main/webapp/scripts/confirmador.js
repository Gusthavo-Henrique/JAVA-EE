/**
 * confirmação de exclusao de contato
 */
function confirmar(idcon) {
	 let resposta = confirm("Confirmar a exclusão deste contato?")
	 if(resposta === true) {
		 window.location.href = "delete?idcon=" +idcon
	 }
}