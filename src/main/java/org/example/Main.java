package org.example;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            UnidadMedida unidad = new UnidadMedida();
            unidad.setDenominacion("Kilogramo");
            em.persist(unidad);

            Categoria categoria = new Categoria();
            categoria.setDenominacion("Bebidas");
            em.persist(categoria);

            ArticuloInsumo insumo = new ArticuloInsumo();
            insumo.setDenominacion("Azúcar");
            insumo.setPrecioCompra(5.0);
            insumo.setPrecioVenta(10.0);
            insumo.setStockActual(100);
            insumo.setStockMaximo(200);
            insumo.setEsParaElaborar(false);
            insumo.setUnidadMedida(unidad);
            em.persist(insumo);

            ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();
            articuloManufacturado.setDenominacion("Chocotorta");
            articuloManufacturado.setPrecioVenta(40.0);
            articuloManufacturado.setTiempoEstimadoMinutos(60);
            articuloManufacturado.setPreparacion("Hornear la torta por 60 minutos");
            em.persist(articuloManufacturado);

            ArticuloManufacturadoDetalle detalle = new ArticuloManufacturadoDetalle();
            detalle.setCantidad(2);
            detalle.setArticuloInsumo(insumo);
            detalle.setArticuloManufacturado(articuloManufacturado);
            em.persist(detalle);

            articuloManufacturado.setDetalles(new ArrayList<>());
            articuloManufacturado.getDetalles().add(detalle);

            Domicilio domicilio = new Domicilio();
            domicilio.setCalle("Avenida Belgrano");
            domicilio.setNumero(2486);
            domicilio.setCp(5509);
            em.persist(domicilio);

            Localidad localidad = new Localidad();
            localidad.setNombre("Lujan de Cuyo");
            localidad.setDomicilios(new ArrayList<>());
            localidad.getDomicilios().add(domicilio);
            em.persist(localidad);

            Provincia provincia = new Provincia();
            provincia.setNombre("Mendoza");
            provincia.setLocalidades(new ArrayList<>());
            provincia.getLocalidades().add(localidad);
            em.persist(provincia);

            Pais pais = new Pais();
            pais.setNombre("Argentina");
            pais.setProvincias(new ArrayList<>());
            pais.getProvincias().add(provincia);
            em.persist(pais);

            Cliente cliente = new Cliente();
            cliente.setNombre("Juan");
            cliente.setApellido("Garcia");
            cliente.setTelefono("02614343538");
            cliente.setEmail("juangarcia@gmail.com");
            cliente.setFechaNacimiento(LocalDate.of(1985, 5, 20));
            cliente.setDomicilios(new ArrayList<>());
            cliente.getDomicilios().add(domicilio);
            em.persist(cliente);

            Pedido pedido = new Pedido();
            pedido.setFechaPedido(LocalDate.now());
            pedido.setTotal(100.0);
            pedido.setTotalCosto(70.0);
            pedido.setEstado(Estado.PENDIENTE);
            pedido.setTipoEnvio(TipoEnvio.DELIVERY);
            pedido.setFormaPago(FormaPago.EFECTIVO);
            pedido.setDomicilioPedido(domicilio);
            pedido.setCliente(cliente);
            em.persist(pedido);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
