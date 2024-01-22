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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for ExternalNetworkInjection related events. .
 *
 * @author your_name_here
 */
@Component("externalNetworkInjection-subscriber")
public class ExternalNetworkInjectionSubscriber extends BaseSubscriber {

  public ExternalNetworkInjectionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExternalNetworkInjection>, ExternalNetworkInjection>
      externalNetworkInjectionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExternalNetworkInjectionQuery(),
        ResponseTypes.multipleInstancesOf(ExternalNetworkInjection.class),
        ResponseTypes.instanceOf(ExternalNetworkInjection.class));
  }

  public SubscriptionQueryResult<ExternalNetworkInjection, ExternalNetworkInjection>
      externalNetworkInjectionSubscribe(@DestinationVariable UUID externalNetworkInjectionId) {
    return queryGateway.subscriptionQuery(
        new FindExternalNetworkInjectionQuery(
            new LoadExternalNetworkInjectionFilter(externalNetworkInjectionId)),
        ResponseTypes.instanceOf(ExternalNetworkInjection.class),
        ResponseTypes.instanceOf(ExternalNetworkInjection.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
