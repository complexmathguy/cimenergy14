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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcELIN2 as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcELIN2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcELIN2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excELIN2")
@Component("excELIN2-projector")
public class ExcELIN2Projector extends ExcELIN2EntityProjector {

  // core constructor
  public ExcELIN2Projector(ExcELIN2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcELIN2Event
   */
  @EventHandler(payloadType = CreateExcELIN2Event.class)
  public void handle(CreateExcELIN2Event event) {
    LOGGER.info("handling CreateExcELIN2Event - " + event);
    ExcELIN2 entity = new ExcELIN2();
    entity.setExcELIN2Id(event.getExcELIN2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UpdateExcELIN2Event
   */
  @EventHandler(payloadType = UpdateExcELIN2Event.class)
  public void handle(UpdateExcELIN2Event event) {
    LOGGER.info("handling UpdateExcELIN2Event - " + event);

    ExcELIN2 entity = new ExcELIN2();
    entity.setExcELIN2Id(event.getExcELIN2Id());
    entity.setEfdbas(event.getEfdbas());
    entity.setIefmax(event.getIefmax());
    entity.setIefmax2(event.getIefmax2());
    entity.setIefmin(event.getIefmin());
    entity.setK1(event.getK1());
    entity.setK1ec(event.getK1ec());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setK4(event.getK4());
    entity.setKd1(event.getKd1());
    entity.setKe2(event.getKe2());
    entity.setKetb(event.getKetb());
    entity.setPid1max(event.getPid1max());
    entity.setSeve1(event.getSeve1());
    entity.setSeve2(event.getSeve2());
    entity.setTb1(event.getTb1());
    entity.setTe(event.getTe());
    entity.setTe2(event.getTe2());
    entity.setTi1(event.getTi1());
    entity.setTi3(event.getTi3());
    entity.setTi4(event.getTi4());
    entity.setTr4(event.getTr4());
    entity.setUpmax(event.getUpmax());
    entity.setUpmin(event.getUpmin());
    entity.setVe1(event.getVe1());
    entity.setVe2(event.getVe2());
    entity.setXp(event.getXp());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event DeleteExcELIN2Event
   */
  @EventHandler(payloadType = DeleteExcELIN2Event.class)
  public void handle(DeleteExcELIN2Event event) {
    LOGGER.info("handling DeleteExcELIN2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcELIN2 entity = delete(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignEfdbasToExcELIN2Event
   */
  @EventHandler(payloadType = AssignEfdbasToExcELIN2Event.class)
  public void handle(AssignEfdbasToExcELIN2Event event) {
    LOGGER.info("handling AssignEfdbasToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignEfdbas(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignEfdbasFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignEfdbasFromExcELIN2Event.class)
  public void handle(UnAssignEfdbasFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignEfdbasFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignEfdbas(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignIefmaxToExcELIN2Event
   */
  @EventHandler(payloadType = AssignIefmaxToExcELIN2Event.class)
  public void handle(AssignIefmaxToExcELIN2Event event) {
    LOGGER.info("handling AssignIefmaxToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignIefmax(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignIefmaxFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignIefmaxFromExcELIN2Event.class)
  public void handle(UnAssignIefmaxFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignIefmaxFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignIefmax(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignIefmax2ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignIefmax2ToExcELIN2Event.class)
  public void handle(AssignIefmax2ToExcELIN2Event event) {
    LOGGER.info("handling AssignIefmax2ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignIefmax2(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignIefmax2FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignIefmax2FromExcELIN2Event.class)
  public void handle(UnAssignIefmax2FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignIefmax2FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignIefmax2(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignIefminToExcELIN2Event
   */
  @EventHandler(payloadType = AssignIefminToExcELIN2Event.class)
  public void handle(AssignIefminToExcELIN2Event event) {
    LOGGER.info("handling AssignIefminToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignIefmin(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignIefminFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignIefminFromExcELIN2Event.class)
  public void handle(UnAssignIefminFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignIefminFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignIefmin(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignK1ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignK1ToExcELIN2Event.class)
  public void handle(AssignK1ToExcELIN2Event event) {
    LOGGER.info("handling AssignK1ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignK1(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignK1FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignK1FromExcELIN2Event.class)
  public void handle(UnAssignK1FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignK1FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignK1(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignK1ecToExcELIN2Event
   */
  @EventHandler(payloadType = AssignK1ecToExcELIN2Event.class)
  public void handle(AssignK1ecToExcELIN2Event event) {
    LOGGER.info("handling AssignK1ecToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignK1ec(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignK1ecFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignK1ecFromExcELIN2Event.class)
  public void handle(UnAssignK1ecFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignK1ecFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignK1ec(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignK2ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignK2ToExcELIN2Event.class)
  public void handle(AssignK2ToExcELIN2Event event) {
    LOGGER.info("handling AssignK2ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignK2(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignK2FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignK2FromExcELIN2Event.class)
  public void handle(UnAssignK2FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignK2FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignK2(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignK3ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignK3ToExcELIN2Event.class)
  public void handle(AssignK3ToExcELIN2Event event) {
    LOGGER.info("handling AssignK3ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignK3(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignK3FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignK3FromExcELIN2Event.class)
  public void handle(UnAssignK3FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignK3FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignK3(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignK4ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignK4ToExcELIN2Event.class)
  public void handle(AssignK4ToExcELIN2Event event) {
    LOGGER.info("handling AssignK4ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignK4(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignK4FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignK4FromExcELIN2Event.class)
  public void handle(UnAssignK4FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignK4FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignK4(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignKd1ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignKd1ToExcELIN2Event.class)
  public void handle(AssignKd1ToExcELIN2Event event) {
    LOGGER.info("handling AssignKd1ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignKd1(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignKd1FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignKd1FromExcELIN2Event.class)
  public void handle(UnAssignKd1FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignKd1FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignKd1(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignKe2ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignKe2ToExcELIN2Event.class)
  public void handle(AssignKe2ToExcELIN2Event event) {
    LOGGER.info("handling AssignKe2ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignKe2(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignKe2FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignKe2FromExcELIN2Event.class)
  public void handle(UnAssignKe2FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignKe2FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignKe2(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignKetbToExcELIN2Event
   */
  @EventHandler(payloadType = AssignKetbToExcELIN2Event.class)
  public void handle(AssignKetbToExcELIN2Event event) {
    LOGGER.info("handling AssignKetbToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignKetb(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignKetbFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignKetbFromExcELIN2Event.class)
  public void handle(UnAssignKetbFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignKetbFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignKetb(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignPid1maxToExcELIN2Event
   */
  @EventHandler(payloadType = AssignPid1maxToExcELIN2Event.class)
  public void handle(AssignPid1maxToExcELIN2Event event) {
    LOGGER.info("handling AssignPid1maxToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignPid1max(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignPid1maxFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignPid1maxFromExcELIN2Event.class)
  public void handle(UnAssignPid1maxFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignPid1maxFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignPid1max(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignSeve1ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignSeve1ToExcELIN2Event.class)
  public void handle(AssignSeve1ToExcELIN2Event event) {
    LOGGER.info("handling AssignSeve1ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignSeve1(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignSeve1FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignSeve1FromExcELIN2Event.class)
  public void handle(UnAssignSeve1FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignSeve1FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignSeve1(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignSeve2ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignSeve2ToExcELIN2Event.class)
  public void handle(AssignSeve2ToExcELIN2Event event) {
    LOGGER.info("handling AssignSeve2ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignSeve2(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignSeve2FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignSeve2FromExcELIN2Event.class)
  public void handle(UnAssignSeve2FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignSeve2FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignSeve2(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignTb1ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignTb1ToExcELIN2Event.class)
  public void handle(AssignTb1ToExcELIN2Event event) {
    LOGGER.info("handling AssignTb1ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignTb1(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignTb1FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignTb1FromExcELIN2Event.class)
  public void handle(UnAssignTb1FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignTb1FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignTb1(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignTeToExcELIN2Event
   */
  @EventHandler(payloadType = AssignTeToExcELIN2Event.class)
  public void handle(AssignTeToExcELIN2Event event) {
    LOGGER.info("handling AssignTeToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignTe(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignTeFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignTeFromExcELIN2Event.class)
  public void handle(UnAssignTeFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignTeFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignTe(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignTe2ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignTe2ToExcELIN2Event.class)
  public void handle(AssignTe2ToExcELIN2Event event) {
    LOGGER.info("handling AssignTe2ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignTe2(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignTe2FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignTe2FromExcELIN2Event.class)
  public void handle(UnAssignTe2FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignTe2FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignTe2(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignTi1ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignTi1ToExcELIN2Event.class)
  public void handle(AssignTi1ToExcELIN2Event event) {
    LOGGER.info("handling AssignTi1ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignTi1(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignTi1FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignTi1FromExcELIN2Event.class)
  public void handle(UnAssignTi1FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignTi1FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignTi1(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignTi3ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignTi3ToExcELIN2Event.class)
  public void handle(AssignTi3ToExcELIN2Event event) {
    LOGGER.info("handling AssignTi3ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignTi3(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignTi3FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignTi3FromExcELIN2Event.class)
  public void handle(UnAssignTi3FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignTi3FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignTi3(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignTi4ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignTi4ToExcELIN2Event.class)
  public void handle(AssignTi4ToExcELIN2Event event) {
    LOGGER.info("handling AssignTi4ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignTi4(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignTi4FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignTi4FromExcELIN2Event.class)
  public void handle(UnAssignTi4FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignTi4FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignTi4(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignTr4ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignTr4ToExcELIN2Event.class)
  public void handle(AssignTr4ToExcELIN2Event event) {
    LOGGER.info("handling AssignTr4ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignTr4(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignTr4FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignTr4FromExcELIN2Event.class)
  public void handle(UnAssignTr4FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignTr4FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignTr4(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignUpmaxToExcELIN2Event
   */
  @EventHandler(payloadType = AssignUpmaxToExcELIN2Event.class)
  public void handle(AssignUpmaxToExcELIN2Event event) {
    LOGGER.info("handling AssignUpmaxToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignUpmax(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignUpmaxFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignUpmaxFromExcELIN2Event.class)
  public void handle(UnAssignUpmaxFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignUpmaxFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignUpmax(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignUpminToExcELIN2Event
   */
  @EventHandler(payloadType = AssignUpminToExcELIN2Event.class)
  public void handle(AssignUpminToExcELIN2Event event) {
    LOGGER.info("handling AssignUpminToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignUpmin(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignUpminFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignUpminFromExcELIN2Event.class)
  public void handle(UnAssignUpminFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignUpminFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignUpmin(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignVe1ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignVe1ToExcELIN2Event.class)
  public void handle(AssignVe1ToExcELIN2Event event) {
    LOGGER.info("handling AssignVe1ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignVe1(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignVe1FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignVe1FromExcELIN2Event.class)
  public void handle(UnAssignVe1FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignVe1FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignVe1(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignVe2ToExcELIN2Event
   */
  @EventHandler(payloadType = AssignVe2ToExcELIN2Event.class)
  public void handle(AssignVe2ToExcELIN2Event event) {
    LOGGER.info("handling AssignVe2ToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignVe2(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignVe2FromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignVe2FromExcELIN2Event.class)
  public void handle(UnAssignVe2FromExcELIN2Event event) {
    LOGGER.info("handling UnAssignVe2FromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignVe2(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event AssignXpToExcELIN2Event
   */
  @EventHandler(payloadType = AssignXpToExcELIN2Event.class)
  public void handle(AssignXpToExcELIN2Event event) {
    LOGGER.info("handling AssignXpToExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcELIN2 entity = assignXp(event.getExcELIN2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /*
   * @param	event UnAssignXpFromExcELIN2Event
   */
  @EventHandler(payloadType = UnAssignXpFromExcELIN2Event.class)
  public void handle(UnAssignXpFromExcELIN2Event event) {
    LOGGER.info("handling UnAssignXpFromExcELIN2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcELIN2 entity = unAssignXp(event.getExcELIN2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcELIN2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcELIN2(entity);
  }

  /**
   * Method to retrieve the ExcELIN2 via an ExcELIN2PrimaryKey.
   *
   * @param id Long
   * @return ExcELIN2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcELIN2 handle(FindExcELIN2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcELIN2Id());
  }

  /**
   * Method to retrieve a collection of all ExcELIN2s
   *
   * @param query FindAllExcELIN2Query
   * @return List<ExcELIN2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcELIN2> handle(FindAllExcELIN2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcELIN2, but only if the id matches
   *
   * @param entity ExcELIN2
   */
  protected void emitFindExcELIN2(ExcELIN2 entity) {
    LOGGER.info("handling emitFindExcELIN2");

    queryUpdateEmitter.emit(
        FindExcELIN2Query.class,
        query -> query.getFilter().getExcELIN2Id().equals(entity.getExcELIN2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcELIN2
   *
   * @param entity ExcELIN2
   */
  protected void emitFindAllExcELIN2(ExcELIN2 entity) {
    LOGGER.info("handling emitFindAllExcELIN2");

    queryUpdateEmitter.emit(FindAllExcELIN2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcELIN2Projector.class.getName());
}
