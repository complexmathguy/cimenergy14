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
 * Subscriber for ExcIEEEAC2A related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEAC2A-subscriber")
public class ExcIEEEAC2ASubscriber extends BaseSubscriber {

  public ExcIEEEAC2ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEAC2A>, ExcIEEEAC2A> excIEEEAC2ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEAC2AQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEAC2A.class),
        ResponseTypes.instanceOf(ExcIEEEAC2A.class));
  }

  public SubscriptionQueryResult<ExcIEEEAC2A, ExcIEEEAC2A> excIEEEAC2ASubscribe(
      @DestinationVariable UUID excIEEEAC2AId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEAC2AQuery(new LoadExcIEEEAC2AFilter(excIEEEAC2AId)),
        ResponseTypes.instanceOf(ExcIEEEAC2A.class),
        ResponseTypes.instanceOf(ExcIEEEAC2A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
