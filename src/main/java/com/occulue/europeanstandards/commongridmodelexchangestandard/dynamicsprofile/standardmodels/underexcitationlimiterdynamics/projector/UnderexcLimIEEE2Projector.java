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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.underexcitationlimiterdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for UnderexcLimIEEE2 as outlined for the CQRS pattern. All event handling and query
 * handling related to UnderexcLimIEEE2 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by UnderexcLimIEEE2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("underexcLimIEEE2")
@Component("underexcLimIEEE2-projector")
public class UnderexcLimIEEE2Projector extends UnderexcLimIEEE2EntityProjector {

  // core constructor
  public UnderexcLimIEEE2Projector(
      UnderexcLimIEEE2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = CreateUnderexcLimIEEE2Event.class)
  public void handle(CreateUnderexcLimIEEE2Event event) {
    LOGGER.info("handling CreateUnderexcLimIEEE2Event - " + event);
    UnderexcLimIEEE2 entity = new UnderexcLimIEEE2();
    entity.setUnderexcLimIEEE2Id(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UpdateUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UpdateUnderexcLimIEEE2Event.class)
  public void handle(UpdateUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UpdateUnderexcLimIEEE2Event - " + event);

    UnderexcLimIEEE2 entity = new UnderexcLimIEEE2();
    entity.setUnderexcLimIEEE2Id(event.getUnderexcLimIEEE2Id());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setKfb(event.getKfb());
    entity.setKuf(event.getKuf());
    entity.setKui(event.getKui());
    entity.setKul(event.getKul());
    entity.setP0(event.getP0());
    entity.setP1(event.getP1());
    entity.setP10(event.getP10());
    entity.setP2(event.getP2());
    entity.setP3(event.getP3());
    entity.setP4(event.getP4());
    entity.setP5(event.getP5());
    entity.setP6(event.getP6());
    entity.setP7(event.getP7());
    entity.setP8(event.getP8());
    entity.setP9(event.getP9());
    entity.setQ0(event.getQ0());
    entity.setQ1(event.getQ1());
    entity.setQ10(event.getQ10());
    entity.setQ2(event.getQ2());
    entity.setQ3(event.getQ3());
    entity.setQ4(event.getQ4());
    entity.setQ5(event.getQ5());
    entity.setQ6(event.getQ6());
    entity.setQ7(event.getQ7());
    entity.setQ8(event.getQ8());
    entity.setQ9(event.getQ9());
    entity.setTu1(event.getTu1());
    entity.setTu2(event.getTu2());
    entity.setTu3(event.getTu3());
    entity.setTu4(event.getTu4());
    entity.setTul(event.getTul());
    entity.setTup(event.getTup());
    entity.setTuq(event.getTuq());
    entity.setTuv(event.getTuv());
    entity.setVuimax(event.getVuimax());
    entity.setVuimin(event.getVuimin());
    entity.setVulmax(event.getVulmax());
    entity.setVulmin(event.getVulmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event DeleteUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = DeleteUnderexcLimIEEE2Event.class)
  public void handle(DeleteUnderexcLimIEEE2Event event) {
    LOGGER.info("handling DeleteUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    UnderexcLimIEEE2 entity = delete(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignK1ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignK1ToUnderexcLimIEEE2Event.class)
  public void handle(AssignK1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignK1ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignK1(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignK1FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignK1FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignK1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignK1FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignK1(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignK2ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignK2ToUnderexcLimIEEE2Event.class)
  public void handle(AssignK2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignK2ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignK2(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignK2FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignK2FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignK2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignK2FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignK2(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignKfbToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignKfbToUnderexcLimIEEE2Event.class)
  public void handle(AssignKfbToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignKfbToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignKfb(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignKfbFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignKfbFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignKfbFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignKfbFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignKfb(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignKufToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignKufToUnderexcLimIEEE2Event.class)
  public void handle(AssignKufToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignKufToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignKuf(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignKufFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignKufFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignKufFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignKufFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignKuf(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignKuiToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignKuiToUnderexcLimIEEE2Event.class)
  public void handle(AssignKuiToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignKuiToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignKui(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignKuiFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignKuiFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignKuiFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignKuiFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignKui(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignKulToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignKulToUnderexcLimIEEE2Event.class)
  public void handle(AssignKulToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignKulToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignKul(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignKulFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignKulFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignKulFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignKulFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignKul(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP0ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP0ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP0ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP0ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP0(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP0FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP0FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP0FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP0FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP0(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP1ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP1ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP1ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP1(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP1FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP1FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP1FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP1(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP10ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP10ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP10ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP10ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP10(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP10FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP10FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP10FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP10FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP10(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP2ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP2ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP2ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP2(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP2FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP2FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP2FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP2(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP3ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP3ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP3ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP3ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP3(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP3FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP3FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP3FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP3FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP3(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP4ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP4ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP4ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP4ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP4(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP4FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP4FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP4FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP4FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP4(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP5ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP5ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP5ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP5ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP5(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP5FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP5FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP5FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP5FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP5(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP6ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP6ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP6ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP6ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP6(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP6FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP6FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP6FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP6FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP6(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP7ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP7ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP7ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP7ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP7(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP7FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP7FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP7FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP7FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP7(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP8ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP8ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP8ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP8ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP8(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP8FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP8FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP8FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP8FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP8(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignP9ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignP9ToUnderexcLimIEEE2Event.class)
  public void handle(AssignP9ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignP9ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignP9(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignP9FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignP9FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignP9FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignP9FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignP9(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ0ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ0ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ0ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ0ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ0(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ0FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ0FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ0FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ0FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ0(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ1ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ1ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ1ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ1(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ1FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ1FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ1FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ1(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ10ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ10ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ10ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ10ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ10(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ10FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ10FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ10FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ10FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ10(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ2ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ2ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ2ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ2(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ2FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ2FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ2FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ2(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ3ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ3ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ3ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ3ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ3(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ3FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ3FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ3FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ3FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ3(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ4ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ4ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ4ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ4ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ4(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ4FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ4FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ4FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ4FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ4(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ5ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ5ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ5ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ5ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ5(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ5FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ5FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ5FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ5FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ5(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ6ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ6ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ6ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ6ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ6(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ6FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ6FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ6FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ6FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ6(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ7ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ7ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ7ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ7ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ7(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ7FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ7FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ7FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ7FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ7(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ8ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ8ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ8ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ8ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ8(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ8FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ8FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ8FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ8FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ8(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignQ9ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignQ9ToUnderexcLimIEEE2Event.class)
  public void handle(AssignQ9ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignQ9ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignQ9(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignQ9FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignQ9FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignQ9FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignQ9FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignQ9(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTu1ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTu1ToUnderexcLimIEEE2Event.class)
  public void handle(AssignTu1ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTu1ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTu1(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTu1FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTu1FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTu1FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTu1FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTu1(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTu2ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTu2ToUnderexcLimIEEE2Event.class)
  public void handle(AssignTu2ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTu2ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTu2(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTu2FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTu2FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTu2FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTu2FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTu2(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTu3ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTu3ToUnderexcLimIEEE2Event.class)
  public void handle(AssignTu3ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTu3ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTu3(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTu3FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTu3FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTu3FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTu3FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTu3(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTu4ToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTu4ToUnderexcLimIEEE2Event.class)
  public void handle(AssignTu4ToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTu4ToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTu4(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTu4FromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTu4FromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTu4FromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTu4FromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTu4(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTulToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTulToUnderexcLimIEEE2Event.class)
  public void handle(AssignTulToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTulToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTul(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTulFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTulFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTulFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTulFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTul(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTupToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTupToUnderexcLimIEEE2Event.class)
  public void handle(AssignTupToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTupToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTup(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTupFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTupFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTupFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTupFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTup(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTuqToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTuqToUnderexcLimIEEE2Event.class)
  public void handle(AssignTuqToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTuqToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTuq(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTuqFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTuqFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTuqFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTuqFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTuq(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignTuvToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignTuvToUnderexcLimIEEE2Event.class)
  public void handle(AssignTuvToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignTuvToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignTuv(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignTuvFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTuvFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignTuvFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignTuvFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignTuv(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignVuimaxToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignVuimaxToUnderexcLimIEEE2Event.class)
  public void handle(AssignVuimaxToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignVuimaxToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignVuimax(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignVuimaxFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignVuimaxFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignVuimaxFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignVuimaxFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignVuimax(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignVuiminToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignVuiminToUnderexcLimIEEE2Event.class)
  public void handle(AssignVuiminToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignVuiminToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignVuimin(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignVuiminFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignVuiminFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignVuiminFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignVuiminFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignVuimin(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignVulmaxToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignVulmaxToUnderexcLimIEEE2Event.class)
  public void handle(AssignVulmaxToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignVulmaxToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignVulmax(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignVulmaxFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignVulmaxFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignVulmaxFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignVulmaxFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignVulmax(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event AssignVulminToUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = AssignVulminToUnderexcLimIEEE2Event.class)
  public void handle(AssignVulminToUnderexcLimIEEE2Event event) {
    LOGGER.info("handling AssignVulminToUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE2 entity = assignVulmin(event.getUnderexcLimIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /*
   * @param	event UnAssignVulminFromUnderexcLimIEEE2Event
   */
  @EventHandler(payloadType = UnAssignVulminFromUnderexcLimIEEE2Event.class)
  public void handle(UnAssignVulminFromUnderexcLimIEEE2Event event) {
    LOGGER.info("handling UnAssignVulminFromUnderexcLimIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE2 entity = unAssignVulmin(event.getUnderexcLimIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE2(entity);
  }

  /**
   * Method to retrieve the UnderexcLimIEEE2 via an UnderexcLimIEEE2PrimaryKey.
   *
   * @param id Long
   * @return UnderexcLimIEEE2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public UnderexcLimIEEE2 handle(FindUnderexcLimIEEE2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getUnderexcLimIEEE2Id());
  }

  /**
   * Method to retrieve a collection of all UnderexcLimIEEE2s
   *
   * @param query FindAllUnderexcLimIEEE2Query
   * @return List<UnderexcLimIEEE2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<UnderexcLimIEEE2> handle(FindAllUnderexcLimIEEE2Query query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindUnderexcLimIEEE2, but only if the id matches
   *
   * @param entity UnderexcLimIEEE2
   */
  protected void emitFindUnderexcLimIEEE2(UnderexcLimIEEE2 entity) {
    LOGGER.info("handling emitFindUnderexcLimIEEE2");

    queryUpdateEmitter.emit(
        FindUnderexcLimIEEE2Query.class,
        query -> query.getFilter().getUnderexcLimIEEE2Id().equals(entity.getUnderexcLimIEEE2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllUnderexcLimIEEE2
   *
   * @param entity UnderexcLimIEEE2
   */
  protected void emitFindAllUnderexcLimIEEE2(UnderexcLimIEEE2 entity) {
    LOGGER.info("handling emitFindAllUnderexcLimIEEE2");

    queryUpdateEmitter.emit(FindAllUnderexcLimIEEE2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE2Projector.class.getName());
}
