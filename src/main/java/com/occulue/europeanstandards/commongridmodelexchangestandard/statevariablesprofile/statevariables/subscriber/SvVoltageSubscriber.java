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
 * Subscriber for SvVoltage related events. .
 *
 * @author your_name_here
 */
@Component("svVoltage-subscriber")
public class SvVoltageSubscriber extends BaseSubscriber {

  public SvVoltageSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<SvVoltage>, SvVoltage> svVoltageSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllSvVoltageQuery(),
        ResponseTypes.multipleInstancesOf(SvVoltage.class),
        ResponseTypes.instanceOf(SvVoltage.class));
  }

  public SubscriptionQueryResult<SvVoltage, SvVoltage> svVoltageSubscribe(
      @DestinationVariable UUID svVoltageId) {
    return queryGateway.subscriptionQuery(
        new FindSvVoltageQuery(new LoadSvVoltageFilter(svVoltageId)),
        ResponseTypes.instanceOf(SvVoltage.class),
        ResponseTypes.instanceOf(SvVoltage.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
