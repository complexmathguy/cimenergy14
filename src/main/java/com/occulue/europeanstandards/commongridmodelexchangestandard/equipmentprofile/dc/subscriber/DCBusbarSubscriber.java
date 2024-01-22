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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

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
 * Subscriber for DCBusbar related events. .
 *
 * @author your_name_here
 */
@Component("dCBusbar-subscriber")
public class DCBusbarSubscriber extends BaseSubscriber {

  public DCBusbarSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCBusbar>, DCBusbar> dCBusbarSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCBusbarQuery(),
        ResponseTypes.multipleInstancesOf(DCBusbar.class),
        ResponseTypes.instanceOf(DCBusbar.class));
  }

  public SubscriptionQueryResult<DCBusbar, DCBusbar> dCBusbarSubscribe(
      @DestinationVariable UUID dCBusbarId) {
    return queryGateway.subscriptionQuery(
        new FindDCBusbarQuery(new LoadDCBusbarFilter(dCBusbarId)),
        ResponseTypes.instanceOf(DCBusbar.class),
        ResponseTypes.instanceOf(DCBusbar.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
