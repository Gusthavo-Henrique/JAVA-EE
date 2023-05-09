/**
 * VALIDAÇÃO DE FORMULARIO
 */

 function validar(){
	 let nome = frmContato.nome.value
	 let telefone = frmContato.telefone.value
	 if( nome === "") {
		 alert('Preenchar o campo Nome')
		 frmContato.nome.focus
		 return false
	 }
	 else if( telefone === "") {
		 alert('Preenchar o campo Telefone')
		 frmContato.telefone.focus
		 return false
	 }
	 else {
		 document.forms[frmContato].submit()
	 }
 }