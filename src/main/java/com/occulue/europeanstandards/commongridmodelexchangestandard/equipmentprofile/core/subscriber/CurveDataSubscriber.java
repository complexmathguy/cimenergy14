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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for CurveData related events. .
 *
 * @author your_name_here
 */
@Component("curveData-subscriber")
public class CurveDataSubscriber extends BaseSubscriber {

  public CurveDataSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<CurveData>, CurveData> curveDataSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllCurveDataQuery(),
        ResponseTypes.multipleInstancesOf(CurveData.class),
        ResponseTypes.instanceOf(CurveData.class));
  }

  public SubscriptionQueryResult<CurveData, CurveData> curveDataSubscribe(
      @DestinationVariable UUID curveDataId) {
    return queryGateway.subscriptionQuery(
        new FindCurveDataQuery(new LoadCurveDataFilter(curveDataId)),
        ResponseTypes.instanceOf(CurveData.class),
        ResponseTypes.instanceOf(CurveData.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
