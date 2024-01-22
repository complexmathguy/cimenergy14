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
 * Subscriber for WindType1or2UserDefined related events. .
 *
 * @author your_name_here
 */
@Component("windType1or2UserDefined-subscriber")
public class WindType1or2UserDefinedSubscriber extends BaseSubscriber {

  public WindType1or2UserDefinedSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<WindType1or2UserDefined>, WindType1or2UserDefined>
      windType1or2UserDefinedSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllWindType1or2UserDefinedQuery(),
        ResponseTypes.multipleInstancesOf(WindType1or2UserDefined.class),
        ResponseTypes.instanceOf(WindType1or2UserDefined.class));
  }

  public SubscriptionQueryResult<WindType1or2UserDefined, WindType1or2UserDefined>
      windType1or2UserDefinedSubscribe(@DestinationVariable UUID windType1or2UserDefinedId) {
    return queryGateway.subscriptionQuery(
        new FindWindType1or2UserDefinedQuery(
            new LoadWindType1or2UserDefinedFilter(windType1or2UserDefinedId)),
        ResponseTypes.instanceOf(WindType1or2UserDefined.class),
        ResponseTypes.instanceOf(WindType1or2UserDefined.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
