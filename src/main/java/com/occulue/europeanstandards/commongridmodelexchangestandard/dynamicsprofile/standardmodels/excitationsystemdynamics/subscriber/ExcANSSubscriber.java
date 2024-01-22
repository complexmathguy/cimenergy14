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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.subscriber;

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
 * Subscriber for ExcANS related events. .
 *
 * @author your_name_here
 */
@Component("excANS-subscriber")
public class ExcANSSubscriber extends BaseSubscriber {

  public ExcANSSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcANS>, ExcANS> excANSSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcANSQuery(),
        ResponseTypes.multipleInstancesOf(ExcANS.class),
        ResponseTypes.instanceOf(ExcANS.class));
  }

  public SubscriptionQueryResult<ExcANS, ExcANS> excANSSubscribe(
      @DestinationVariable UUID excANSId) {
    return queryGateway.subscriptionQuery(
        new FindExcANSQuery(new LoadExcANSFilter(excANSId)),
        ResponseTypes.instanceOf(ExcANS.class),
        ResponseTypes.instanceOf(ExcANS.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
