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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.subscriber;

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
 * Subscriber for WindPlantDynamics related events. .
 *
 * @author your_name_here
 */
@Component("windPlantDynamics-subscriber")
public class WindPlantDynamicsSubscriber extends BaseSubscriber {

  public WindPlantDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindPlantDynamics>, WindPlantDynamics>
      windPlantDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindPlantDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(WindPlantDynamics.class),
        ResponseTypes.instanceOf(WindPlantDynamics.class));
  }

  public SubscriptionQueryResult<WindPlantDynamics, WindPlantDynamics> windPlantDynamicsSubscribe(
      @DestinationVariable UUID windPlantDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindWindPlantDynamicsQuery(new LoadWindPlantDynamicsFilter(windPlantDynamicsId)),
        ResponseTypes.instanceOf(WindPlantDynamics.class),
        ResponseTypes.instanceOf(WindPlantDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
