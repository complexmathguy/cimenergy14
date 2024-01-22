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
 * Subscriber for WindContQIEC related events. .
 *
 * @author your_name_here
 */
@Component("windContQIEC-subscriber")
public class WindContQIECSubscriber extends BaseSubscriber {

  public WindContQIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindContQIEC>, WindContQIEC> windContQIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindContQIECQuery(),
        ResponseTypes.multipleInstancesOf(WindContQIEC.class),
        ResponseTypes.instanceOf(WindContQIEC.class));
  }

  public SubscriptionQueryResult<WindContQIEC, WindContQIEC> windContQIECSubscribe(
      @DestinationVariable UUID windContQIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindContQIECQuery(new LoadWindContQIECFilter(windContQIECId)),
        ResponseTypes.instanceOf(WindContQIEC.class),
        ResponseTypes.instanceOf(WindContQIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
