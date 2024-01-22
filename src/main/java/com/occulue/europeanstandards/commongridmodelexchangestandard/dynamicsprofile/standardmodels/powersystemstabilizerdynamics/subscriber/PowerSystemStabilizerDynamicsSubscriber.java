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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.subscriber;

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
 * Subscriber for PowerSystemStabilizerDynamics related events. .
 *
 * @author your_name_here
 */
@Component("powerSystemStabilizerDynamics-subscriber")
public class PowerSystemStabilizerDynamicsSubscriber extends BaseSubscriber {

  public PowerSystemStabilizerDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PowerSystemStabilizerDynamics>, PowerSystemStabilizerDynamics>
      powerSystemStabilizerDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPowerSystemStabilizerDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(PowerSystemStabilizerDynamics.class),
        ResponseTypes.instanceOf(PowerSystemStabilizerDynamics.class));
  }

  public SubscriptionQueryResult<PowerSystemStabilizerDynamics, PowerSystemStabilizerDynamics>
      powerSystemStabilizerDynamicsSubscribe(
          @DestinationVariable UUID powerSystemStabilizerDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindPowerSystemStabilizerDynamicsQuery(
            new LoadPowerSystemStabilizerDynamicsFilter(powerSystemStabilizerDynamicsId)),
        ResponseTypes.instanceOf(PowerSystemStabilizerDynamics.class),
        ResponseTypes.instanceOf(PowerSystemStabilizerDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
