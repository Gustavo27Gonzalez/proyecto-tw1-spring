package ar.edu.unlam.tallerweb1.domain.compra;

public interface RepositorioCompra {

	void guardar(Compra nuevaCompra);

	Compra buscarPorId(Long idCompra);

}
