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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.core.subscriber;

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
 * Subscriber for IdentifiedObject related events. .
 *
 * @author your_name_here
 */
@Component("identifiedObject-subscriber")
public class IdentifiedObjectSubscriber extends BaseSubscriber {

  public IdentifiedObjectSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<IdentifiedObject>, IdentifiedObject>
      identifiedObjectSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllIdentifiedObjectQuery(),
        ResponseTypes.multipleInstancesOf(IdentifiedObject.class),
        ResponseTypes.instanceOf(IdentifiedObject.class));
  }

  public SubscriptionQueryResult<IdentifiedObject, IdentifiedObject> identifiedObjectSubscribe(
      @DestinationVariable UUID identifiedObjectId) {
    return queryGateway.subscriptionQuery(
        new FindIdentifiedObjectQuery(new LoadIdentifiedObjectFilter(identifiedObjectId)),
        ResponseTypes.instanceOf(IdentifiedObject.class),
        ResponseTypes.instanceOf(IdentifiedObject.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
