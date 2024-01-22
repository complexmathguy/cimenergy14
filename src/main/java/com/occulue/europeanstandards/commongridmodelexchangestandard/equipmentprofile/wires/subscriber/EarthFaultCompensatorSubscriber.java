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
 * Subscriber for EarthFaultCompensator related events. .
 *
 * @author your_name_here
 */
@Component("earthFaultCompensator-subscriber")
public class EarthFaultCompensatorSubscriber extends BaseSubscriber {

  public EarthFaultCompensatorSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<EarthFaultCompensator>, EarthFaultCompensator>
      earthFaultCompensatorSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllEarthFaultCompensatorQuery(),
        ResponseTypes.multipleInstancesOf(EarthFaultCompensator.class),
        ResponseTypes.instanceOf(EarthFaultCompensator.class));
  }

  public SubscriptionQueryResult<EarthFaultCompensator, EarthFaultCompensator>
      earthFaultCompensatorSubscribe(@DestinationVariable UUID earthFaultCompensatorId) {
    return queryGateway.subscriptionQuery(
        new FindEarthFaultCompensatorQuery(
            new LoadEarthFaultCompensatorFilter(earthFaultCompensatorId)),
        ResponseTypes.instanceOf(EarthFaultCompensator.class),
        ResponseTypes.instanceOf(EarthFaultCompensator.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
