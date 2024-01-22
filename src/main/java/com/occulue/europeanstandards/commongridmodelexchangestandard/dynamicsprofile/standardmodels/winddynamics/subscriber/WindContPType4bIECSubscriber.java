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
 * Subscriber for WindContPType4bIEC related events. .
 *
 * @author your_name_here
 */
@Component("windContPType4bIEC-subscriber")
public class WindContPType4bIECSubscriber extends BaseSubscriber {

  public WindContPType4bIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindContPType4bIEC>, WindContPType4bIEC>
      windContPType4bIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindContPType4bIECQuery(),
        ResponseTypes.multipleInstancesOf(WindContPType4bIEC.class),
        ResponseTypes.instanceOf(WindContPType4bIEC.class));
  }

  public SubscriptionQueryResult<WindContPType4bIEC, WindContPType4bIEC>
      windContPType4bIECSubscribe(@DestinationVariable UUID windContPType4bIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindContPType4bIECQuery(new LoadWindContPType4bIECFilter(windContPType4bIECId)),
        ResponseTypes.instanceOf(WindContPType4bIEC.class),
        ResponseTypes.instanceOf(WindContPType4bIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
