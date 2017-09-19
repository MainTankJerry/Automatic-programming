/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.model.mtl.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.acceleo.model.mtl.util.MtlAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters
 * generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged
 * fireNotifyChanged}. The adapters also support Eclipse property sheets. Note that most of the adapters are
 * shared among multiple instances. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MtlItemProviderAdapterFactory extends MtlAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MtlItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.Module}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ModuleItemProvider moduleItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.Module}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createModuleAdapter() {
		if (moduleItemProvider == null) {
			moduleItemProvider = new ModuleItemProvider(this);
		}

		return moduleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.acceleo.model.mtl.TemplateExpression} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected TemplateExpressionItemProvider templateExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.TemplateExpression}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTemplateExpressionAdapter() {
		if (templateExpressionItemProvider == null) {
			templateExpressionItemProvider = new TemplateExpressionItemProvider(this);
		}

		return templateExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.Block} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockItemProvider blockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.Block}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createBlockAdapter() {
		if (blockItemProvider == null) {
			blockItemProvider = new BlockItemProvider(this);
		}

		return blockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.InitSection}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InitSectionItemProvider initSectionItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.InitSection}. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createInitSectionAdapter() {
		if (initSectionItemProvider == null) {
			initSectionItemProvider = new InitSectionItemProvider(this);
		}

		return initSectionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.Template}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TemplateItemProvider templateItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.Template}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTemplateAdapter() {
		if (templateItemProvider == null) {
			templateItemProvider = new TemplateItemProvider(this);
		}

		return templateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.acceleo.model.mtl.TemplateInvocation} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected TemplateInvocationItemProvider templateInvocationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.TemplateInvocation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTemplateInvocationAdapter() {
		if (templateInvocationItemProvider == null) {
			templateInvocationItemProvider = new TemplateInvocationItemProvider(this);
		}

		return templateInvocationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.Query} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QueryItemProvider queryItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.Query}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createQueryAdapter() {
		if (queryItemProvider == null) {
			queryItemProvider = new QueryItemProvider(this);
		}

		return queryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.QueryInvocation}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QueryInvocationItemProvider queryInvocationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.QueryInvocation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createQueryInvocationAdapter() {
		if (queryInvocationItemProvider == null) {
			queryInvocationItemProvider = new QueryInvocationItemProvider(this);
		}

		return queryInvocationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.eclipse.acceleo.model.mtl.ProtectedAreaBlock} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProtectedAreaBlockItemProvider protectedAreaBlockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.ProtectedAreaBlock}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createProtectedAreaBlockAdapter() {
		if (protectedAreaBlockItemProvider == null) {
			protectedAreaBlockItemProvider = new ProtectedAreaBlockItemProvider(this);
		}

		return protectedAreaBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.ForBlock}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ForBlockItemProvider forBlockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.ForBlock}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createForBlockAdapter() {
		if (forBlockItemProvider == null) {
			forBlockItemProvider = new ForBlockItemProvider(this);
		}

		return forBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.IfBlock}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IfBlockItemProvider ifBlockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.IfBlock}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createIfBlockAdapter() {
		if (ifBlockItemProvider == null) {
			ifBlockItemProvider = new IfBlockItemProvider(this);
		}

		return ifBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.LetBlock}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LetBlockItemProvider letBlockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.LetBlock}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createLetBlockAdapter() {
		if (letBlockItemProvider == null) {
			letBlockItemProvider = new LetBlockItemProvider(this);
		}

		return letBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.FileBlock}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FileBlockItemProvider fileBlockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.FileBlock}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createFileBlockAdapter() {
		if (fileBlockItemProvider == null) {
			fileBlockItemProvider = new FileBlockItemProvider(this);
		}

		return fileBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.TraceBlock}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TraceBlockItemProvider traceBlockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.TraceBlock}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTraceBlockAdapter() {
		if (traceBlockItemProvider == null) {
			traceBlockItemProvider = new TraceBlockItemProvider(this);
		}

		return traceBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.Macro} instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MacroItemProvider macroItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.Macro}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createMacroAdapter() {
		if (macroItemProvider == null) {
			macroItemProvider = new MacroItemProvider(this);
		}

		return macroItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.MacroInvocation}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MacroInvocationItemProvider macroInvocationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.MacroInvocation}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createMacroInvocationAdapter() {
		if (macroInvocationItemProvider == null) {
			macroInvocationItemProvider = new MacroInvocationItemProvider(this);
		}

		return macroInvocationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.acceleo.model.mtl.TypedModel}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TypedModelItemProvider typedModelItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.acceleo.model.mtl.TypedModel}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTypedModelAdapter() {
		if (typedModelItemProvider == null) {
			typedModelItemProvider = new TypedModelItemProvider(this);
		}

		return typedModelItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void dispose() {
		if (moduleItemProvider != null) {
			moduleItemProvider.dispose();
		}
		if (templateExpressionItemProvider != null) {
			templateExpressionItemProvider.dispose();
		}
		if (blockItemProvider != null) {
			blockItemProvider.dispose();
		}
		if (initSectionItemProvider != null) {
			initSectionItemProvider.dispose();
		}
		if (templateItemProvider != null) {
			templateItemProvider.dispose();
		}
		if (templateInvocationItemProvider != null) {
			templateInvocationItemProvider.dispose();
		}
		if (queryItemProvider != null) {
			queryItemProvider.dispose();
		}
		if (queryInvocationItemProvider != null) {
			queryInvocationItemProvider.dispose();
		}
		if (protectedAreaBlockItemProvider != null) {
			protectedAreaBlockItemProvider.dispose();
		}
		if (forBlockItemProvider != null) {
			forBlockItemProvider.dispose();
		}
		if (ifBlockItemProvider != null) {
			ifBlockItemProvider.dispose();
		}
		if (letBlockItemProvider != null) {
			letBlockItemProvider.dispose();
		}
		if (fileBlockItemProvider != null) {
			fileBlockItemProvider.dispose();
		}
		if (traceBlockItemProvider != null) {
			traceBlockItemProvider.dispose();
		}
		if (macroItemProvider != null) {
			macroItemProvider.dispose();
		}
		if (macroInvocationItemProvider != null) {
			macroInvocationItemProvider.dispose();
		}
		if (typedModelItemProvider != null) {
			typedModelItemProvider.dispose();
		}
	}

}