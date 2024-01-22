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
 * Subscriber for WindTurbineType1or2Dynamics related events. .
 *
 * @author your_name_here
 */
@Component("windTurbineType1or2Dynamics-subscriber")
public class WindTurbineType1or2DynamicsSubscriber extends BaseSubscriber {

  public WindTurbineType1or2DynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindTurbineType1or2Dynamics>, WindTurbineType1or2Dynamics>
      windTurbineType1or2DynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindTurbineType1or2DynamicsQuery(),
        ResponseTypes.multipleInstancesOf(WindTurbineType1or2Dynamics.class),
        ResponseTypes.instanceOf(WindTurbineType1or2Dynamics.class));
  }

  public SubscriptionQueryResult<WindTurbineType1or2Dynamics, WindTurbineType1or2Dynamics>
      windTurbineType1or2DynamicsSubscribe(
          @DestinationVariable UUID windTurbineType1or2DynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindWindTurbineType1or2DynamicsQuery(
            new LoadWindTurbineType1or2DynamicsFilter(windTurbineType1or2DynamicsId)),
        ResponseTypes.instanceOf(WindTurbineType1or2Dynamics.class),
        ResponseTypes.instanceOf(WindTurbineType1or2Dynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
