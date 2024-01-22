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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for Simple_Float related events. .
 *
 * @author your_name_here
 */
@Component("simple_Float-subscriber")
public class Simple_FloatSubscriber extends BaseSubscriber {

  public Simple_FloatSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Simple_Float>, Simple_Float> simple_FloatSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSimple_FloatQuery(),
        ResponseTypes.multipleInstancesOf(Simple_Float.class),
        ResponseTypes.instanceOf(Simple_Float.class));
  }

  public SubscriptionQueryResult<Simple_Float, Simple_Float> simple_FloatSubscribe(
      @DestinationVariable UUID simple_FloatId) {
    return queryGateway.subscriptionQuery(
        new FindSimple_FloatQuery(new LoadSimple_FloatFilter(simple_FloatId)),
        ResponseTypes.instanceOf(Simple_Float.class),
        ResponseTypes.instanceOf(Simple_Float.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
