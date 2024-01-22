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
 * Subscriber for ENTSOEJunction related events. .
 *
 * @author your_name_here
 */
@Component("eNTSOEJunction-subscriber")
public class ENTSOEJunctionSubscriber extends BaseSubscriber {

  public ENTSOEJunctionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ENTSOEJunction>, ENTSOEJunction> eNTSOEJunctionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllENTSOEJunctionQuery(),
        ResponseTypes.multipleInstancesOf(ENTSOEJunction.class),
        ResponseTypes.instanceOf(ENTSOEJunction.class));
  }

  public SubscriptionQueryResult<ENTSOEJunction, ENTSOEJunction> eNTSOEJunctionSubscribe(
      @DestinationVariable UUID eNTSOEJunctionId) {
    return queryGateway.subscriptionQuery(
        new FindENTSOEJunctionQuery(new LoadENTSOEJunctionFilter(eNTSOEJunctionId)),
        ResponseTypes.instanceOf(ENTSOEJunction.class),
        ResponseTypes.instanceOf(ENTSOEJunction.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
