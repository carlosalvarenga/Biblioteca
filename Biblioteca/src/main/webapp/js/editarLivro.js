//valida o formulario
function validarFormulario() {
	var campo = document.getElementById('formulario:nome_livro');
	var campo1 = document.getElementById('formulario:assunto');
	var campo2 = document.getElementById('formulario:numero_pagina');
	var campo3 = document.getElementById('formulario:data_inicio');
	var campo4 = document.getElementById('formulario:data_entrega');
	var campo5 = document.getElementById('formulario:preco');
	if (campo.value.length == 0) {
		alert('O campo nome deve ser preenchido.');
		campo.focus();
		return false;
	}
	if (campo1.value.length == 0) {
		alert('O campo assunto deve ser preenchido.');
		campo.focus();
		return false;
	}
	if (campo2.value.length == 0) {
		alert('O campo numero de pagina deve ser preenchido.');
		campo.focus();
		return false;
	}
	if (campo3.value.length == 0) {
		alert('O campo data inicio deve ser preenchido.');
		campo.focus();
		return false;
	}
	if (campo4.value.length == 0) {
		alert('O campo data entrega deve ser preenchido.');
		campo.focus();
		return false;
	}
	if (campo5.value.length == 0) {
		alert('O campo preco  deve ser preenchido.');
		campo.focus();
		return false;
	}
	return true;
}