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
 * Projector for UnderexcLimIEEE1 as outlined for the CQRS pattern. All event handling and query
 * handling related to UnderexcLimIEEE1 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by UnderexcLimIEEE1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("underexcLimIEEE1")
@Component("underexcLimIEEE1-projector")
public class UnderexcLimIEEE1Projector extends UnderexcLimIEEE1EntityProjector {

  // core constructor
  public UnderexcLimIEEE1Projector(
      UnderexcLimIEEE1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = CreateUnderexcLimIEEE1Event.class)
  public void handle(CreateUnderexcLimIEEE1Event event) {
    LOGGER.info("handling CreateUnderexcLimIEEE1Event - " + event);
    UnderexcLimIEEE1 entity = new UnderexcLimIEEE1();
    entity.setUnderexcLimIEEE1Id(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UpdateUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UpdateUnderexcLimIEEE1Event.class)
  public void handle(UpdateUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UpdateUnderexcLimIEEE1Event - " + event);

    UnderexcLimIEEE1 entity = new UnderexcLimIEEE1();
    entity.setUnderexcLimIEEE1Id(event.getUnderexcLimIEEE1Id());
    entity.setKuc(event.getKuc());
    entity.setKuf(event.getKuf());
    entity.setKui(event.getKui());
    entity.setKul(event.getKul());
    entity.setKur(event.getKur());
    entity.setTu1(event.getTu1());
    entity.setTu2(event.getTu2());
    entity.setTu3(event.getTu3());
    entity.setTu4(event.getTu4());
    entity.setVucmax(event.getVucmax());
    entity.setVuimax(event.getVuimax());
    entity.setVuimin(event.getVuimin());
    entity.setVulmax(event.getVulmax());
    entity.setVulmin(event.getVulmin());
    entity.setVurmax(event.getVurmax());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event DeleteUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = DeleteUnderexcLimIEEE1Event.class)
  public void handle(DeleteUnderexcLimIEEE1Event event) {
    LOGGER.info("handling DeleteUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    UnderexcLimIEEE1 entity = delete(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignKucToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignKucToUnderexcLimIEEE1Event.class)
  public void handle(AssignKucToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignKucToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignKuc(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignKucFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignKucFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignKucFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignKucFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignKuc(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignKufToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignKufToUnderexcLimIEEE1Event.class)
  public void handle(AssignKufToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignKufToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignKuf(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignKufFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignKufFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignKufFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignKufFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignKuf(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignKuiToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignKuiToUnderexcLimIEEE1Event.class)
  public void handle(AssignKuiToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignKuiToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignKui(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignKuiFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignKuiFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignKuiFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignKuiFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignKui(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignKulToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignKulToUnderexcLimIEEE1Event.class)
  public void handle(AssignKulToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignKulToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignKul(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignKulFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignKulFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignKulFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignKulFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignKul(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignKurToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignKurToUnderexcLimIEEE1Event.class)
  public void handle(AssignKurToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignKurToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignKur(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignKurFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignKurFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignKurFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignKurFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignKur(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignTu1ToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignTu1ToUnderexcLimIEEE1Event.class)
  public void handle(AssignTu1ToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignTu1ToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignTu1(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignTu1FromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignTu1FromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignTu1FromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignTu1FromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignTu1(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignTu2ToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignTu2ToUnderexcLimIEEE1Event.class)
  public void handle(AssignTu2ToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignTu2ToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignTu2(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignTu2FromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignTu2FromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignTu2FromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignTu2FromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignTu2(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignTu3ToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignTu3ToUnderexcLimIEEE1Event.class)
  public void handle(AssignTu3ToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignTu3ToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignTu3(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignTu3FromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignTu3FromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignTu3FromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignTu3FromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignTu3(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignTu4ToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignTu4ToUnderexcLimIEEE1Event.class)
  public void handle(AssignTu4ToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignTu4ToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignTu4(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignTu4FromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignTu4FromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignTu4FromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignTu4FromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignTu4(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignVucmaxToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignVucmaxToUnderexcLimIEEE1Event.class)
  public void handle(AssignVucmaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignVucmaxToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignVucmax(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignVucmaxFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignVucmaxFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignVucmaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignVucmaxFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignVucmax(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignVuimaxToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignVuimaxToUnderexcLimIEEE1Event.class)
  public void handle(AssignVuimaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignVuimaxToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignVuimax(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignVuimaxFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignVuimaxFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignVuimaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignVuimaxFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignVuimax(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignVuiminToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignVuiminToUnderexcLimIEEE1Event.class)
  public void handle(AssignVuiminToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignVuiminToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignVuimin(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignVuiminFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignVuiminFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignVuiminFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignVuiminFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignVuimin(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignVulmaxToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignVulmaxToUnderexcLimIEEE1Event.class)
  public void handle(AssignVulmaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignVulmaxToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignVulmax(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignVulmaxFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignVulmaxFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignVulmaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignVulmaxFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignVulmax(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignVulminToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignVulminToUnderexcLimIEEE1Event.class)
  public void handle(AssignVulminToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignVulminToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignVulmin(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignVulminFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignVulminFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignVulminFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignVulminFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignVulmin(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event AssignVurmaxToUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = AssignVurmaxToUnderexcLimIEEE1Event.class)
  public void handle(AssignVurmaxToUnderexcLimIEEE1Event event) {
    LOGGER.info("handling AssignVurmaxToUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    UnderexcLimIEEE1 entity = assignVurmax(event.getUnderexcLimIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /*
   * @param	event UnAssignVurmaxFromUnderexcLimIEEE1Event
   */
  @EventHandler(payloadType = UnAssignVurmaxFromUnderexcLimIEEE1Event.class)
  public void handle(UnAssignVurmaxFromUnderexcLimIEEE1Event event) {
    LOGGER.info("handling UnAssignVurmaxFromUnderexcLimIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    UnderexcLimIEEE1 entity = unAssignVurmax(event.getUnderexcLimIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindUnderexcLimIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllUnderexcLimIEEE1(entity);
  }

  /**
   * Method to retrieve the UnderexcLimIEEE1 via an UnderexcLimIEEE1PrimaryKey.
   *
   * @param id Long
   * @return UnderexcLimIEEE1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public UnderexcLimIEEE1 handle(FindUnderexcLimIEEE1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getUnderexcLimIEEE1Id());
  }

  /**
   * Method to retrieve a collection of all UnderexcLimIEEE1s
   *
   * @param query FindAllUnderexcLimIEEE1Query
   * @return List<UnderexcLimIEEE1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<UnderexcLimIEEE1> handle(FindAllUnderexcLimIEEE1Query query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindUnderexcLimIEEE1, but only if the id matches
   *
   * @param entity UnderexcLimIEEE1
   */
  protected void emitFindUnderexcLimIEEE1(UnderexcLimIEEE1 entity) {
    LOGGER.info("handling emitFindUnderexcLimIEEE1");

    queryUpdateEmitter.emit(
        FindUnderexcLimIEEE1Query.class,
        query -> query.getFilter().getUnderexcLimIEEE1Id().equals(entity.getUnderexcLimIEEE1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllUnderexcLimIEEE1
   *
   * @param entity UnderexcLimIEEE1
   */
  protected void emitFindAllUnderexcLimIEEE1(UnderexcLimIEEE1 entity) {
    LOGGER.info("handling emitFindAllUnderexcLimIEEE1");

    queryUpdateEmitter.emit(FindAllUnderexcLimIEEE1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(UnderexcLimIEEE1Projector.class.getName());
}
