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
 * Subscriber for PowerTransformerEnd related events. .
 *
 * @author your_name_here
 */
@Component("powerTransformerEnd-subscriber")
public class PowerTransformerEndSubscriber extends BaseSubscriber {

  public PowerTransformerEndSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PowerTransformerEnd>, PowerTransformerEnd>
      powerTransformerEndSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPowerTransformerEndQuery(),
        ResponseTypes.multipleInstancesOf(PowerTransformerEnd.class),
        ResponseTypes.instanceOf(PowerTransformerEnd.class));
  }

  public SubscriptionQueryResult<PowerTransformerEnd, PowerTransformerEnd>
      powerTransformerEndSubscribe(@DestinationVariable UUID powerTransformerEndId) {
    return queryGateway.subscriptionQuery(
        new FindPowerTransformerEndQuery(new LoadPowerTransformerEndFilter(powerTransformerEndId)),
        ResponseTypes.instanceOf(PowerTransformerEnd.class),
        ResponseTypes.instanceOf(PowerTransformerEnd.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
