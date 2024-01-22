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
 * Subscriber for PowerTransformer related events. .
 *
 * @author your_name_here
 */
@Component("powerTransformer-subscriber")
public class PowerTransformerSubscriber extends BaseSubscriber {

  public PowerTransformerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PowerTransformer>, PowerTransformer>
      powerTransformerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPowerTransformerQuery(),
        ResponseTypes.multipleInstancesOf(PowerTransformer.class),
        ResponseTypes.instanceOf(PowerTransformer.class));
  }

  public SubscriptionQueryResult<PowerTransformer, PowerTransformer> powerTransformerSubscribe(
      @DestinationVariable UUID powerTransformerId) {
    return queryGateway.subscriptionQuery(
        new FindPowerTransformerQuery(new LoadPowerTransformerFilter(powerTransformerId)),
        ResponseTypes.instanceOf(PowerTransformer.class),
        ResponseTypes.instanceOf(PowerTransformer.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
