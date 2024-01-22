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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.userdefinedmodels.subscriber;

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
 * Subscriber for WindType3or4UserDefined related events. .
 *
 * @author your_name_here
 */
@Component("windType3or4UserDefined-subscriber")
public class WindType3or4UserDefinedSubscriber extends BaseSubscriber {

  public WindType3or4UserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindType3or4UserDefined>, WindType3or4UserDefined>
      windType3or4UserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindType3or4UserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(WindType3or4UserDefined.class),
        ResponseTypes.instanceOf(WindType3or4UserDefined.class));
  }

  public SubscriptionQueryResult<WindType3or4UserDefined, WindType3or4UserDefined>
      windType3or4UserDefinedSubscribe(@DestinationVariable UUID windType3or4UserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindWindType3or4UserDefinedQuery(
            new LoadWindType3or4UserDefinedFilter(windType3or4UserDefinedId)),
        ResponseTypes.instanceOf(WindType3or4UserDefined.class),
        ResponseTypes.instanceOf(WindType3or4UserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
