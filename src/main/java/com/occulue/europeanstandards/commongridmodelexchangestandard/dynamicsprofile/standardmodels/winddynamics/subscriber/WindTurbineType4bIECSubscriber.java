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
 * Subscriber for WindTurbineType4bIEC related events. .
 *
 * @author your_name_here
 */
@Component("windTurbineType4bIEC-subscriber")
public class WindTurbineType4bIECSubscriber extends BaseSubscriber {

  public WindTurbineType4bIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindTurbineType4bIEC>, WindTurbineType4bIEC>
      windTurbineType4bIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindTurbineType4bIECQuery(),
        ResponseTypes.multipleInstancesOf(WindTurbineType4bIEC.class),
        ResponseTypes.instanceOf(WindTurbineType4bIEC.class));
  }

  public SubscriptionQueryResult<WindTurbineType4bIEC, WindTurbineType4bIEC>
      windTurbineType4bIECSubscribe(@DestinationVariable UUID windTurbineType4bIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindTurbineType4bIECQuery(
            new LoadWindTurbineType4bIECFilter(windTurbineType4bIECId)),
        ResponseTypes.instanceOf(WindTurbineType4bIEC.class),
        ResponseTypes.instanceOf(WindTurbineType4bIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
