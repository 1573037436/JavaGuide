/**
 * ArgoServiceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.navis.www.services.argoservice;

public class ArgoServiceSoapBindingSkeleton implements com.navis.www.services.argoservice.ArgoServicePort, org.apache.axis.wsdl.Skeleton {
    private com.navis.www.services.argoservice.ArgoServicePort impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.navis.com/services/argoservice", "scopeCoordinateIdsWsType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://types.webservice.argo.navis.com/v1.0", "ScopeCoordinateIdsWsType"), com.navis.argo.webservice.types.v1_0.ScopeCoordinateIdsWsType.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.navis.com/services/argoservice", "xmlDoc"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("genericInvoke", _params, new javax.xml.namespace.QName("http://www.navis.com/services/argoservice", "genericInvokeResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://types.webservice.argo.navis.com/v1.0", "GenericInvokeResponseWsType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.navis.com/services/argoservice", "genericInvoke"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("genericInvoke") == null) {
            _myOperations.put("genericInvoke", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("genericInvoke")).add(_oper);
    }

    public ArgoServiceSoapBindingSkeleton() {
        this.impl = new com.navis.www.services.argoservice.ArgoServiceSoapBindingImpl();
    }

    public ArgoServiceSoapBindingSkeleton(com.navis.www.services.argoservice.ArgoServicePort impl) {
        this.impl = impl;
    }
    public com.navis.argo.webservice.types.v1_0.GenericInvokeResponseWsType genericInvoke(com.navis.argo.webservice.types.v1_0.ScopeCoordinateIdsWsType scopeCoordinateIdsWsType, java.lang.String xmlDoc) throws java.rmi.RemoteException
    {
        com.navis.argo.webservice.types.v1_0.GenericInvokeResponseWsType ret = impl.genericInvoke(scopeCoordinateIdsWsType, xmlDoc);
        return ret;
    }

}
