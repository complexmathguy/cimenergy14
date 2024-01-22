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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PssIEEE4B as outlined for the CQRS pattern. All event handling and query handling
 * related to PssIEEE4B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by PssIEEE4BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pssIEEE4B")
@Component("pssIEEE4B-projector")
public class PssIEEE4BProjector extends PssIEEE4BEntityProjector {

  // core constructor
  public PssIEEE4BProjector(PssIEEE4BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePssIEEE4BEvent
   */
  @EventHandler(payloadType = CreatePssIEEE4BEvent.class)
  public void handle(CreatePssIEEE4BEvent event) {
    LOGGER.info("handling CreatePssIEEE4BEvent - " + event);
    PssIEEE4B entity = new PssIEEE4B();
    entity.setPssIEEE4BId(event.getPssIEEE4BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UpdatePssIEEE4BEvent
   */
  @EventHandler(payloadType = UpdatePssIEEE4BEvent.class)
  public void handle(UpdatePssIEEE4BEvent event) {
    LOGGER.info("handling UpdatePssIEEE4BEvent - " + event);

    PssIEEE4B entity = new PssIEEE4B();
    entity.setPssIEEE4BId(event.getPssIEEE4BId());
    entity.setBwh1(event.getBwh1());
    entity.setBwh2(event.getBwh2());
    entity.setBwl1(event.getBwl1());
    entity.setBwl2(event.getBwl2());
    entity.setKh(event.getKh());
    entity.setKh1(event.getKh1());
    entity.setKh11(event.getKh11());
    entity.setKh17(event.getKh17());
    entity.setKh2(event.getKh2());
    entity.setKi(event.getKi());
    entity.setKi1(event.getKi1());
    entity.setKi11(event.getKi11());
    entity.setKi17(event.getKi17());
    entity.setKi2(event.getKi2());
    entity.setKl(event.getKl());
    entity.setKl1(event.getKl1());
    entity.setKl11(event.getKl11());
    entity.setKl17(event.getKl17());
    entity.setKl2(event.getKl2());
    entity.setOmeganh1(event.getOmeganh1());
    entity.setOmeganh2(event.getOmeganh2());
    entity.setOmeganl1(event.getOmeganl1());
    entity.setOmeganl2(event.getOmeganl2());
    entity.setTh1(event.getTh1());
    entity.setTh10(event.getTh10());
    entity.setTh11(event.getTh11());
    entity.setTh12(event.getTh12());
    entity.setTh2(event.getTh2());
    entity.setTh3(event.getTh3());
    entity.setTh4(event.getTh4());
    entity.setTh5(event.getTh5());
    entity.setTh6(event.getTh6());
    entity.setTh7(event.getTh7());
    entity.setTh8(event.getTh8());
    entity.setTh9(event.getTh9());
    entity.setTi1(event.getTi1());
    entity.setTi10(event.getTi10());
    entity.setTi11(event.getTi11());
    entity.setTi12(event.getTi12());
    entity.setTi2(event.getTi2());
    entity.setTi3(event.getTi3());
    entity.setTi4(event.getTi4());
    entity.setTi5(event.getTi5());
    entity.setTi6(event.getTi6());
    entity.setTi7(event.getTi7());
    entity.setTi8(event.getTi8());
    entity.setTi9(event.getTi9());
    entity.setTl1(event.getTl1());
    entity.setTl10(event.getTl10());
    entity.setTl11(event.getTl11());
    entity.setTl12(event.getTl12());
    entity.setTl2(event.getTl2());
    entity.setTl3(event.getTl3());
    entity.setTl4(event.getTl4());
    entity.setTl5(event.getTl5());
    entity.setTl6(event.getTl6());
    entity.setTl7(event.getTl7());
    entity.setTl8(event.getTl8());
    entity.setTl9(event.getTl9());
    entity.setVhmax(event.getVhmax());
    entity.setVhmin(event.getVhmin());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVlmax(event.getVlmax());
    entity.setVlmin(event.getVlmin());
    entity.setVstmax(event.getVstmax());
    entity.setVstmin(event.getVstmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event DeletePssIEEE4BEvent
   */
  @EventHandler(payloadType = DeletePssIEEE4BEvent.class)
  public void handle(DeletePssIEEE4BEvent event) {
    LOGGER.info("handling DeletePssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PssIEEE4B entity = delete(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignBwh1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignBwh1ToPssIEEE4BEvent.class)
  public void handle(AssignBwh1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignBwh1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignBwh1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignBwh1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignBwh1FromPssIEEE4BEvent.class)
  public void handle(UnAssignBwh1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignBwh1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignBwh1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignBwh2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignBwh2ToPssIEEE4BEvent.class)
  public void handle(AssignBwh2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignBwh2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignBwh2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignBwh2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignBwh2FromPssIEEE4BEvent.class)
  public void handle(UnAssignBwh2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignBwh2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignBwh2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignBwl1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignBwl1ToPssIEEE4BEvent.class)
  public void handle(AssignBwl1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignBwl1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignBwl1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignBwl1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignBwl1FromPssIEEE4BEvent.class)
  public void handle(UnAssignBwl1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignBwl1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignBwl1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignBwl2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignBwl2ToPssIEEE4BEvent.class)
  public void handle(AssignBwl2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignBwl2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignBwl2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignBwl2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignBwl2FromPssIEEE4BEvent.class)
  public void handle(UnAssignBwl2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignBwl2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignBwl2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKhToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKhToPssIEEE4BEvent.class)
  public void handle(AssignKhToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKhToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKh(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKhFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKhFromPssIEEE4BEvent.class)
  public void handle(UnAssignKhFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKhFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKh(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKh1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKh1ToPssIEEE4BEvent.class)
  public void handle(AssignKh1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKh1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKh1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKh1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKh1FromPssIEEE4BEvent.class)
  public void handle(UnAssignKh1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKh1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKh1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKh11ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKh11ToPssIEEE4BEvent.class)
  public void handle(AssignKh11ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKh11ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKh11(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKh11FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKh11FromPssIEEE4BEvent.class)
  public void handle(UnAssignKh11FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKh11FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKh11(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKh17ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKh17ToPssIEEE4BEvent.class)
  public void handle(AssignKh17ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKh17ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKh17(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKh17FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKh17FromPssIEEE4BEvent.class)
  public void handle(UnAssignKh17FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKh17FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKh17(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKh2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKh2ToPssIEEE4BEvent.class)
  public void handle(AssignKh2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKh2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKh2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKh2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKh2FromPssIEEE4BEvent.class)
  public void handle(UnAssignKh2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKh2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKh2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKiToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKiToPssIEEE4BEvent.class)
  public void handle(AssignKiToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKiToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKi(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKiFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKiFromPssIEEE4BEvent.class)
  public void handle(UnAssignKiFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKiFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKi(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKi1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKi1ToPssIEEE4BEvent.class)
  public void handle(AssignKi1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKi1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKi1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKi1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKi1FromPssIEEE4BEvent.class)
  public void handle(UnAssignKi1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKi1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKi1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKi11ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKi11ToPssIEEE4BEvent.class)
  public void handle(AssignKi11ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKi11ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKi11(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKi11FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKi11FromPssIEEE4BEvent.class)
  public void handle(UnAssignKi11FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKi11FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKi11(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKi17ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKi17ToPssIEEE4BEvent.class)
  public void handle(AssignKi17ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKi17ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKi17(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKi17FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKi17FromPssIEEE4BEvent.class)
  public void handle(UnAssignKi17FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKi17FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKi17(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKi2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKi2ToPssIEEE4BEvent.class)
  public void handle(AssignKi2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKi2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKi2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKi2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKi2FromPssIEEE4BEvent.class)
  public void handle(UnAssignKi2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKi2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKi2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKlToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKlToPssIEEE4BEvent.class)
  public void handle(AssignKlToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKlToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKl(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKlFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKlFromPssIEEE4BEvent.class)
  public void handle(UnAssignKlFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKlFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKl(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKl1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKl1ToPssIEEE4BEvent.class)
  public void handle(AssignKl1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKl1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKl1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKl1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKl1FromPssIEEE4BEvent.class)
  public void handle(UnAssignKl1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKl1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKl1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKl11ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKl11ToPssIEEE4BEvent.class)
  public void handle(AssignKl11ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKl11ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKl11(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKl11FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKl11FromPssIEEE4BEvent.class)
  public void handle(UnAssignKl11FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKl11FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKl11(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKl17ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKl17ToPssIEEE4BEvent.class)
  public void handle(AssignKl17ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKl17ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKl17(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKl17FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKl17FromPssIEEE4BEvent.class)
  public void handle(UnAssignKl17FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKl17FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKl17(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignKl2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignKl2ToPssIEEE4BEvent.class)
  public void handle(AssignKl2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignKl2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignKl2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignKl2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignKl2FromPssIEEE4BEvent.class)
  public void handle(UnAssignKl2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignKl2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignKl2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignOmeganh1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignOmeganh1ToPssIEEE4BEvent.class)
  public void handle(AssignOmeganh1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignOmeganh1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignOmeganh1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignOmeganh1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignOmeganh1FromPssIEEE4BEvent.class)
  public void handle(UnAssignOmeganh1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignOmeganh1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignOmeganh1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignOmeganh2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignOmeganh2ToPssIEEE4BEvent.class)
  public void handle(AssignOmeganh2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignOmeganh2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignOmeganh2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignOmeganh2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignOmeganh2FromPssIEEE4BEvent.class)
  public void handle(UnAssignOmeganh2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignOmeganh2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignOmeganh2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignOmeganl1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignOmeganl1ToPssIEEE4BEvent.class)
  public void handle(AssignOmeganl1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignOmeganl1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignOmeganl1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignOmeganl1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignOmeganl1FromPssIEEE4BEvent.class)
  public void handle(UnAssignOmeganl1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignOmeganl1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignOmeganl1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignOmeganl2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignOmeganl2ToPssIEEE4BEvent.class)
  public void handle(AssignOmeganl2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignOmeganl2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignOmeganl2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignOmeganl2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignOmeganl2FromPssIEEE4BEvent.class)
  public void handle(UnAssignOmeganl2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignOmeganl2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignOmeganl2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh1ToPssIEEE4BEvent.class)
  public void handle(AssignTh1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh1FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh10ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh10ToPssIEEE4BEvent.class)
  public void handle(AssignTh10ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh10ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh10(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh10FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh10FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh10FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh10FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh10(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh11ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh11ToPssIEEE4BEvent.class)
  public void handle(AssignTh11ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh11ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh11(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh11FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh11FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh11FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh11FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh11(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh12ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh12ToPssIEEE4BEvent.class)
  public void handle(AssignTh12ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh12ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh12(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh12FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh12FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh12FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh12FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh12(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh2ToPssIEEE4BEvent.class)
  public void handle(AssignTh2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh2FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh3ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh3ToPssIEEE4BEvent.class)
  public void handle(AssignTh3ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh3ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh3(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh3FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh3FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh3FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh3FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh3(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh4ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh4ToPssIEEE4BEvent.class)
  public void handle(AssignTh4ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh4ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh4(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh4FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh4FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh4FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh4FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh4(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh5ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh5ToPssIEEE4BEvent.class)
  public void handle(AssignTh5ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh5ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh5(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh5FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh5FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh5FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh5FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh5(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh6ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh6ToPssIEEE4BEvent.class)
  public void handle(AssignTh6ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh6ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh6(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh6FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh6FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh6FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh6FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh6(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh7ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh7ToPssIEEE4BEvent.class)
  public void handle(AssignTh7ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh7ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh7(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh7FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh7FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh7FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh7FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh7(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh8ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh8ToPssIEEE4BEvent.class)
  public void handle(AssignTh8ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh8ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh8(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh8FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh8FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh8FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh8FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh8(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTh9ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTh9ToPssIEEE4BEvent.class)
  public void handle(AssignTh9ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTh9ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTh9(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTh9FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTh9FromPssIEEE4BEvent.class)
  public void handle(UnAssignTh9FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTh9FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTh9(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi1ToPssIEEE4BEvent.class)
  public void handle(AssignTi1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi1FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi10ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi10ToPssIEEE4BEvent.class)
  public void handle(AssignTi10ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi10ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi10(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi10FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi10FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi10FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi10FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi10(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi11ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi11ToPssIEEE4BEvent.class)
  public void handle(AssignTi11ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi11ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi11(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi11FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi11FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi11FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi11FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi11(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi12ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi12ToPssIEEE4BEvent.class)
  public void handle(AssignTi12ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi12ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi12(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi12FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi12FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi12FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi12FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi12(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi2ToPssIEEE4BEvent.class)
  public void handle(AssignTi2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi2FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi3ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi3ToPssIEEE4BEvent.class)
  public void handle(AssignTi3ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi3ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi3(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi3FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi3FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi3FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi3FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi3(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi4ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi4ToPssIEEE4BEvent.class)
  public void handle(AssignTi4ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi4ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi4(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi4FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi4FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi4FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi4FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi4(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi5ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi5ToPssIEEE4BEvent.class)
  public void handle(AssignTi5ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi5ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi5(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi5FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi5FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi5FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi5FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi5(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi6ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi6ToPssIEEE4BEvent.class)
  public void handle(AssignTi6ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi6ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi6(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi6FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi6FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi6FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi6FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi6(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi7ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi7ToPssIEEE4BEvent.class)
  public void handle(AssignTi7ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi7ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi7(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi7FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi7FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi7FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi7FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi7(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi8ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi8ToPssIEEE4BEvent.class)
  public void handle(AssignTi8ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi8ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi8(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi8FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi8FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi8FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi8FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi8(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTi9ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTi9ToPssIEEE4BEvent.class)
  public void handle(AssignTi9ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTi9ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTi9(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTi9FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTi9FromPssIEEE4BEvent.class)
  public void handle(UnAssignTi9FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTi9FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTi9(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl1ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl1ToPssIEEE4BEvent.class)
  public void handle(AssignTl1ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl1ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl1(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl1FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl1FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl1FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl1FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl1(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl10ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl10ToPssIEEE4BEvent.class)
  public void handle(AssignTl10ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl10ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl10(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl10FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl10FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl10FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl10FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl10(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl11ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl11ToPssIEEE4BEvent.class)
  public void handle(AssignTl11ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl11ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl11(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl11FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl11FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl11FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl11FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl11(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl12ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl12ToPssIEEE4BEvent.class)
  public void handle(AssignTl12ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl12ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl12(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl12FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl12FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl12FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl12FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl12(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl2ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl2ToPssIEEE4BEvent.class)
  public void handle(AssignTl2ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl2ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl2(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl2FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl2FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl2FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl2FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl2(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl3ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl3ToPssIEEE4BEvent.class)
  public void handle(AssignTl3ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl3ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl3(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl3FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl3FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl3FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl3FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl3(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl4ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl4ToPssIEEE4BEvent.class)
  public void handle(AssignTl4ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl4ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl4(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl4FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl4FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl4FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl4FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl4(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl5ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl5ToPssIEEE4BEvent.class)
  public void handle(AssignTl5ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl5ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl5(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl5FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl5FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl5FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl5FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl5(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl6ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl6ToPssIEEE4BEvent.class)
  public void handle(AssignTl6ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl6ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl6(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl6FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl6FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl6FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl6FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl6(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl7ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl7ToPssIEEE4BEvent.class)
  public void handle(AssignTl7ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl7ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl7(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl7FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl7FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl7FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl7FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl7(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl8ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl8ToPssIEEE4BEvent.class)
  public void handle(AssignTl8ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl8ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl8(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl8FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl8FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl8FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl8FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl8(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignTl9ToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignTl9ToPssIEEE4BEvent.class)
  public void handle(AssignTl9ToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignTl9ToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignTl9(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignTl9FromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignTl9FromPssIEEE4BEvent.class)
  public void handle(UnAssignTl9FromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignTl9FromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignTl9(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignVhmaxToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignVhmaxToPssIEEE4BEvent.class)
  public void handle(AssignVhmaxToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignVhmaxToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVhmax(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignVhmaxFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignVhmaxFromPssIEEE4BEvent.class)
  public void handle(UnAssignVhmaxFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignVhmaxFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVhmax(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignVhminToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignVhminToPssIEEE4BEvent.class)
  public void handle(AssignVhminToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignVhminToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVhmin(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignVhminFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignVhminFromPssIEEE4BEvent.class)
  public void handle(UnAssignVhminFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignVhminFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVhmin(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignVimaxToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignVimaxToPssIEEE4BEvent.class)
  public void handle(AssignVimaxToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignVimaxToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVimax(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignVimaxFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromPssIEEE4BEvent.class)
  public void handle(UnAssignVimaxFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignVimaxFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVimax(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignViminToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignViminToPssIEEE4BEvent.class)
  public void handle(AssignViminToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignViminToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVimin(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignViminFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignViminFromPssIEEE4BEvent.class)
  public void handle(UnAssignViminFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignViminFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVimin(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignVlmaxToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignVlmaxToPssIEEE4BEvent.class)
  public void handle(AssignVlmaxToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignVlmaxToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVlmax(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignVlmaxFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignVlmaxFromPssIEEE4BEvent.class)
  public void handle(UnAssignVlmaxFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignVlmaxFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVlmax(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignVlminToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignVlminToPssIEEE4BEvent.class)
  public void handle(AssignVlminToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignVlminToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVlmin(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignVlminFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignVlminFromPssIEEE4BEvent.class)
  public void handle(UnAssignVlminFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignVlminFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVlmin(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignVstmaxToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignVstmaxToPssIEEE4BEvent.class)
  public void handle(AssignVstmaxToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignVstmaxToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVstmax(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignVstmaxFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignVstmaxFromPssIEEE4BEvent.class)
  public void handle(UnAssignVstmaxFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignVstmaxFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVstmax(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event AssignVstminToPssIEEE4BEvent
   */
  @EventHandler(payloadType = AssignVstminToPssIEEE4BEvent.class)
  public void handle(AssignVstminToPssIEEE4BEvent event) {
    LOGGER.info("handling AssignVstminToPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PssIEEE4B entity = assignVstmin(event.getPssIEEE4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /*
   * @param	event UnAssignVstminFromPssIEEE4BEvent
   */
  @EventHandler(payloadType = UnAssignVstminFromPssIEEE4BEvent.class)
  public void handle(UnAssignVstminFromPssIEEE4BEvent event) {
    LOGGER.info("handling UnAssignVstminFromPssIEEE4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PssIEEE4B entity = unAssignVstmin(event.getPssIEEE4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPssIEEE4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPssIEEE4B(entity);
  }

  /**
   * Method to retrieve the PssIEEE4B via an PssIEEE4BPrimaryKey.
   *
   * @param id Long
   * @return PssIEEE4B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PssIEEE4B handle(FindPssIEEE4BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPssIEEE4BId());
  }

  /**
   * Method to retrieve a collection of all PssIEEE4Bs
   *
   * @param query FindAllPssIEEE4BQuery
   * @return List<PssIEEE4B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PssIEEE4B> handle(FindAllPssIEEE4BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPssIEEE4B, but only if the id matches
   *
   * @param entity PssIEEE4B
   */
  protected void emitFindPssIEEE4B(PssIEEE4B entity) {
    LOGGER.info("handling emitFindPssIEEE4B");

    queryUpdateEmitter.emit(
        FindPssIEEE4BQuery.class,
        query -> query.getFilter().getPssIEEE4BId().equals(entity.getPssIEEE4BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPssIEEE4B
   *
   * @param entity PssIEEE4B
   */
  protected void emitFindAllPssIEEE4B(PssIEEE4B entity) {
    LOGGER.info("handling emitFindAllPssIEEE4B");

    queryUpdateEmitter.emit(FindAllPssIEEE4BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PssIEEE4BProjector.class.getName());
}
