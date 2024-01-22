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
 * Subscriber for WindPitchContEmulIEC related events. .
 *
 * @author your_name_here
 */
@Component("windPitchContEmulIEC-subscriber")
public class WindPitchContEmulIECSubscriber extends BaseSubscriber {

  public WindPitchContEmulIECSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindPitchContEmulIEC>, WindPitchContEmulIEC>
      windPitchContEmulIECSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindPitchContEmulIECQuery(),
        ResponseTypes.multipleInstancesOf(WindPitchContEmulIEC.class),
        ResponseTypes.instanceOf(WindPitchContEmulIEC.class));
  }

  public SubscriptionQueryResult<WindPitchContEmulIEC, WindPitchContEmulIEC>
      windPitchContEmulIECSubscribe(@DestinationVariable UUID windPitchContEmulIECId) {
    return queryGateway.subscriptionQuery(
        new FindWindPitchContEmulIECQuery(
            new LoadWindPitchContEmulIECFilter(windPitchContEmulIECId)),
        ResponseTypes.instanceOf(WindPitchContEmulIEC.class),
        ResponseTypes.instanceOf(WindPitchContEmulIEC.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
