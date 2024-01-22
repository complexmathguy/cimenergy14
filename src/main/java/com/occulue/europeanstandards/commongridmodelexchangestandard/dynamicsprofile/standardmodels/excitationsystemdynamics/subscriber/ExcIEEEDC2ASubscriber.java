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
 * Subscriber for ExcIEEEDC2A related events. .
 *
 * @author your_name_here
 */
@Component("excIEEEDC2A-subscriber")
public class ExcIEEEDC2ASubscriber extends BaseSubscriber {

  public ExcIEEEDC2ASubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ExcIEEEDC2A>, ExcIEEEDC2A> excIEEEDC2ASubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllExcIEEEDC2AQuery(),
        ResponseTypes.multipleInstancesOf(ExcIEEEDC2A.class),
        ResponseTypes.instanceOf(ExcIEEEDC2A.class));
  }

  public SubscriptionQueryResult<ExcIEEEDC2A, ExcIEEEDC2A> excIEEEDC2ASubscribe(
      @DestinationVariable UUID excIEEEDC2AId) {
    return queryGateway.subscriptionQuery(
        new FindExcIEEEDC2AQuery(new LoadExcIEEEDC2AFilter(excIEEEDC2AId)),
        ResponseTypes.instanceOf(ExcIEEEDC2A.class),
        ResponseTypes.instanceOf(ExcIEEEDC2A.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
