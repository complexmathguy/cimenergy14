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
 * Subscriber for WindGenTurbineType3bIEC related events. .
 *
 * @author your_name_here
 */
@Component("windGenTurbineType3bIEC-subscriber")
public class WindGenTurbineType3bIECSubscriber extends BaseSubscriber {

  public WindGenTurbineType3bIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindGenTurbineType3bIEC>, WindGenTurbineType3bIEC>
      windGenTurbineType3bIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindGenTurbineType3bIECQuery(),
        ResponseTypes.multipleInstancesOf(WindGenTurbineType3bIEC.class),
        ResponseTypes.instanceOf(WindGenTurbineType3bIEC.class));
  }

  public SubscriptionQueryResult<WindGenTurbineType3bIEC, WindGenTurbineType3bIEC>
      windGenTurbineType3bIECSubscribe(@DestinationVariable UUID windGenTurbineType3bIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindGenTurbineType3bIECQuery(
            new LoadWindGenTurbineType3bIECFilter(windGenTurbineType3bIECId)),
        ResponseTypes.instanceOf(WindGenTurbineType3bIEC.class),
        ResponseTypes.instanceOf(WindGenTurbineType3bIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
