/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.extension.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for ExtensionVersion related events. .
 *
 * @author your_name_here
 */
@Component("extensionVersion-subscriber")
public class ExtensionVersionSubscriber extends BaseSubscriber {

  public ExtensionVersionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExtensionVersion>, ExtensionVersion>
      extensionVersionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExtensionVersionQuery(),
        ResponseTypes.multipleInstancesOf(ExtensionVersion.class),
        ResponseTypes.instanceOf(ExtensionVersion.class));
  }

  public SubscriptionQueryResult<ExtensionVersion, ExtensionVersion> extensionVersionSubscribe(
      @DestinationVariable UUID extensionVersionId) {
    return queryGateway.subscriptionQuery(
        new FindExtensionVersionQuery(new LoadExtensionVersionFilter(extensionVersionId)),
        ResponseTypes.instanceOf(ExtensionVersion.class),
        ResponseTypes.instanceOf(ExtensionVersion.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
