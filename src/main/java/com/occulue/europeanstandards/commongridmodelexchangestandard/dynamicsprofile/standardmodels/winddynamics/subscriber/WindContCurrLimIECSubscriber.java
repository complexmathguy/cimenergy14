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
 * Subscriber for WindContCurrLimIEC related events. .
 *
 * @author your_name_here
 */
@Component("windContCurrLimIEC-subscriber")
public class WindContCurrLimIECSubscriber extends BaseSubscriber {

  public WindContCurrLimIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindContCurrLimIEC>, WindContCurrLimIEC>
      windContCurrLimIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindContCurrLimIECQuery(),
        ResponseTypes.multipleInstancesOf(WindContCurrLimIEC.class),
        ResponseTypes.instanceOf(WindContCurrLimIEC.class));
  }

  public SubscriptionQueryResult<WindContCurrLimIEC, WindContCurrLimIEC>
      windContCurrLimIECSubscribe(@DestinationVariable UUID windContCurrLimIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindContCurrLimIECQuery(new LoadWindContCurrLimIECFilter(windContCurrLimIECId)),
        ResponseTypes.instanceOf(WindContCurrLimIEC.class),
        ResponseTypes.instanceOf(WindContCurrLimIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
