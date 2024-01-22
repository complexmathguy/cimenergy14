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
 * Subscriber for WindContPitchAngleIEC related events. .
 *
 * @author your_name_here
 */
@Component("windContPitchAngleIEC-subscriber")
public class WindContPitchAngleIECSubscriber extends BaseSubscriber {

  public WindContPitchAngleIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindContPitchAngleIEC>, WindContPitchAngleIEC>
      windContPitchAngleIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindContPitchAngleIECQuery(),
        ResponseTypes.multipleInstancesOf(WindContPitchAngleIEC.class),
        ResponseTypes.instanceOf(WindContPitchAngleIEC.class));
  }

  public SubscriptionQueryResult<WindContPitchAngleIEC, WindContPitchAngleIEC>
      windContPitchAngleIECSubscribe(@DestinationVariable UUID windContPitchAngleIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindContPitchAngleIECQuery(
            new LoadWindContPitchAngleIECFilter(windContPitchAngleIECId)),
        ResponseTypes.instanceOf(WindContPitchAngleIEC.class),
        ResponseTypes.instanceOf(WindContPitchAngleIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
