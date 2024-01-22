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
package com.occulue.europeanstandards.commongridmodelexchangestandard.statevariablesprofile.statevariables.subscriber;

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
 * Subscriber for SvInjection related events. .
 *
 * @author your_name_here
 */
@Component("svInjection-subscriber")
public class SvInjectionSubscriber extends BaseSubscriber {

  public SvInjectionSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SvInjection>, SvInjection> svInjectionSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSvInjectionQuery(),
        ResponseTypes.multipleInstancesOf(SvInjection.class),
        ResponseTypes.instanceOf(SvInjection.class));
  }

  public SubscriptionQueryResult<SvInjection, SvInjection> svInjectionSubscribe(
      @DestinationVariable UUID svInjectionId) {
    return queryGateway.subscriptionQuery(
        new FindSvInjectionQuery(new LoadSvInjectionFilter(svInjectionId)),
        ResponseTypes.instanceOf(SvInjection.class),
        ResponseTypes.instanceOf(SvInjection.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
