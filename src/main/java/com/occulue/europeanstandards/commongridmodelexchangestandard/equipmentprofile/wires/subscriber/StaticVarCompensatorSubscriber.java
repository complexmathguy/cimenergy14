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
 * Subscriber for StaticVarCompensator related events. .
 *
 * @author your_name_here
 */
@Component("staticVarCompensator-subscriber")
public class StaticVarCompensatorSubscriber extends BaseSubscriber {

  public StaticVarCompensatorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<StaticVarCompensator>, StaticVarCompensator>
      staticVarCompensatorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllStaticVarCompensatorQuery(),
        ResponseTypes.multipleInstancesOf(StaticVarCompensator.class),
        ResponseTypes.instanceOf(StaticVarCompensator.class));
  }

  public SubscriptionQueryResult<StaticVarCompensator, StaticVarCompensator>
      staticVarCompensatorSubscribe(@DestinationVariable UUID staticVarCompensatorId) {
    return queryGateway.subscriptionQuery(
        new FindStaticVarCompensatorQuery(
            new LoadStaticVarCompensatorFilter(staticVarCompensatorId)),
        ResponseTypes.instanceOf(StaticVarCompensator.class),
        ResponseTypes.instanceOf(StaticVarCompensator.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
