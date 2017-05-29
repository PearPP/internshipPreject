
package com.oceantest.controllers.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.oceantest.controllers.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindByBrandResponse_QNAME = new QName("http://ws.controllers.oceantest.com/", "findByBrandResponse");
    private final static QName _FindById_QNAME = new QName("http://ws.controllers.oceantest.com/", "findById");
    private final static QName _SaleProduct_QNAME = new QName("http://ws.controllers.oceantest.com/", "saleProduct");
    private final static QName _FindAll_QNAME = new QName("http://ws.controllers.oceantest.com/", "findAll");
    private final static QName _Exception_QNAME = new QName("http://ws.controllers.oceantest.com/", "Exception");
    private final static QName _FindByIdResponse_QNAME = new QName("http://ws.controllers.oceantest.com/", "findByIdResponse");
    private final static QName _FindByBrand_QNAME = new QName("http://ws.controllers.oceantest.com/", "findByBrand");
    private final static QName _FindAllResponse_QNAME = new QName("http://ws.controllers.oceantest.com/", "findAllResponse");
    private final static QName _FindByNameAndBrandResponse_QNAME = new QName("http://ws.controllers.oceantest.com/", "findByNameAndBrandResponse");
    private final static QName _SaleProductResponse_QNAME = new QName("http://ws.controllers.oceantest.com/", "saleProductResponse");
    private final static QName _FindByNameAndBrand_QNAME = new QName("http://ws.controllers.oceantest.com/", "findByNameAndBrand");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oceantest.controllers.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link FindByBrandResponse }
     * 
     */
    public FindByBrandResponse createFindByBrandResponse() {
        return new FindByBrandResponse();
    }

    /**
     * Create an instance of {@link SaleProduct }
     * 
     */
    public SaleProduct createSaleProduct() {
        return new SaleProduct();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindByNameAndBrand }
     * 
     */
    public FindByNameAndBrand createFindByNameAndBrand() {
        return new FindByNameAndBrand();
    }

    /**
     * Create an instance of {@link FindByBrand }
     * 
     */
    public FindByBrand createFindByBrand() {
        return new FindByBrand();
    }

    /**
     * Create an instance of {@link SaleProductResponse }
     * 
     */
    public SaleProductResponse createSaleProductResponse() {
        return new SaleProductResponse();
    }

    /**
     * Create an instance of {@link FindByNameAndBrandResponse }
     * 
     */
    public FindByNameAndBrandResponse createFindByNameAndBrandResponse() {
        return new FindByNameAndBrandResponse();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link CategoryEntity }
     * 
     */
    public CategoryEntity createCategoryEntity() {
        return new CategoryEntity();
    }

    /**
     * Create an instance of {@link ProductEntity }
     * 
     */
    public ProductEntity createProductEntity() {
        return new ProductEntity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByBrandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findByBrandResponse")
    public JAXBElement<FindByBrandResponse> createFindByBrandResponse(FindByBrandResponse value) {
        return new JAXBElement<FindByBrandResponse>(_FindByBrandResponse_QNAME, FindByBrandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaleProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "saleProduct")
    public JAXBElement<SaleProduct> createSaleProduct(SaleProduct value) {
        return new JAXBElement<SaleProduct>(_SaleProduct_QNAME, SaleProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByBrand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findByBrand")
    public JAXBElement<FindByBrand> createFindByBrand(FindByBrand value) {
        return new JAXBElement<FindByBrand>(_FindByBrand_QNAME, FindByBrand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameAndBrandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findByNameAndBrandResponse")
    public JAXBElement<FindByNameAndBrandResponse> createFindByNameAndBrandResponse(FindByNameAndBrandResponse value) {
        return new JAXBElement<FindByNameAndBrandResponse>(_FindByNameAndBrandResponse_QNAME, FindByNameAndBrandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaleProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "saleProductResponse")
    public JAXBElement<SaleProductResponse> createSaleProductResponse(SaleProductResponse value) {
        return new JAXBElement<SaleProductResponse>(_SaleProductResponse_QNAME, SaleProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameAndBrand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.controllers.oceantest.com/", name = "findByNameAndBrand")
    public JAXBElement<FindByNameAndBrand> createFindByNameAndBrand(FindByNameAndBrand value) {
        return new JAXBElement<FindByNameAndBrand>(_FindByNameAndBrand_QNAME, FindByNameAndBrand.class, null, value);
    }

}
