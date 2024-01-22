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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * EquipmentBoundaryVersion business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of EquipmentBoundaryVersion related services in the case of a
 *       EquipmentBoundaryVersion business related service failing.
 *   <li>Exposes a simpler, uniform EquipmentBoundaryVersion interface to the business tier, making
 *       it easy for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill EquipmentBoundaryVersion
 *       business related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class EquipmentBoundaryVersionBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public EquipmentBoundaryVersionBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * EquipmentBoundaryVersion Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return EquipmentBoundaryVersionBusinessDelegate
   */
  public static EquipmentBoundaryVersionBusinessDelegate getEquipmentBoundaryVersionInstance() {
    return (new EquipmentBoundaryVersionBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createEquipmentBoundaryVersion(
      CreateEquipmentBoundaryVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getEquipmentBoundaryVersionId() == null)
        command.setEquipmentBoundaryVersionId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateEquipmentBoundaryVersionCommand - by convention the future return value for
      // a create command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateEquipmentBoundaryVersionCommand of EquipmentBoundaryVersion is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create EquipmentBoundaryVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateEquipmentBoundaryVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateEquipmentBoundaryVersion(
      UpdateEquipmentBoundaryVersionCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateEquipmentBoundaryVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save EquipmentBoundaryVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteEquipmentBoundaryVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteEquipmentBoundaryVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteEquipmentBoundaryVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete EquipmentBoundaryVersion using Id = "
              + command.getEquipmentBoundaryVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the EquipmentBoundaryVersion via EquipmentBoundaryVersionFetchOneSummary
   *
   * @param summary EquipmentBoundaryVersionFetchOneSummary
   * @return EquipmentBoundaryVersionFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public EquipmentBoundaryVersion getEquipmentBoundaryVersion(
      EquipmentBoundaryVersionFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException(
          "EquipmentBoundaryVersionFetchOneSummary arg cannot be null");

    EquipmentBoundaryVersion entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a EquipmentBoundaryVersion
      // --------------------------------------
      CompletableFuture<EquipmentBoundaryVersion> futureEntity =
          queryGateway.query(
              new FindEquipmentBoundaryVersionQuery(
                  new LoadEquipmentBoundaryVersionFilter(summary.getEquipmentBoundaryVersionId())),
              ResponseTypes.instanceOf(EquipmentBoundaryVersion.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate EquipmentBoundaryVersion with id "
              + summary.getEquipmentBoundaryVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all EquipmentBoundaryVersions
   *
   * @return List<EquipmentBoundaryVersion>
   * @exception ProcessingException Thrown if any problems
   */
  public List<EquipmentBoundaryVersion> getAllEquipmentBoundaryVersion()
      throws ProcessingException {
    List<EquipmentBoundaryVersion> list = null;

    try {
      CompletableFuture<List<EquipmentBoundaryVersion>> futureList =
          queryGateway.query(
              new FindAllEquipmentBoundaryVersionQuery(),
              ResponseTypes.multipleInstancesOf(EquipmentBoundaryVersion.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BaseUML on EquipmentBoundaryVersion
   *
   * @param command AssignBaseUMLToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseUML(AssignBaseUMLToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BaseUML on EquipmentBoundaryVersion
   *
   * @param command UnAssignBaseUMLFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseUML(UnAssignBaseUMLFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseUML on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BaseURI on EquipmentBoundaryVersion
   *
   * @param command AssignBaseURIToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseURI(AssignBaseURIToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign BaseURI on EquipmentBoundaryVersion
   *
   * @param command UnAssignBaseURIFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseURI(UnAssignBaseURIFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseURI on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Date on EquipmentBoundaryVersion
   *
   * @param command AssignDateToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignDate(AssignDateToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateProxyBusinessDelegate.getDateProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getDateProxyId();
    DateProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get DateProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign Date on EquipmentBoundaryVersion
   *
   * @param command UnAssignDateFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDate(UnAssignDateFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Date on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign DifferenceModelURI on EquipmentBoundaryVersion
   *
   * @param command AssignDifferenceModelURIToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignDifferenceModelURI(
      AssignDifferenceModelURIToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign DifferenceModelURI on EquipmentBoundaryVersion
   *
   * @param command UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDifferenceModelURI(
      UnAssignDifferenceModelURIFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign DifferenceModelURI on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeUML on EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeUMLToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeUML(AssignEntsoeUMLToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EntsoeUML on EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeUML(UnAssignEntsoeUMLFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeUML on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeURIcore on EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeURIcore(AssignEntsoeURIcoreToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EntsoeURIcore on EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeURIcore(
      UnAssignEntsoeURIcoreFromEquipmentBoundaryVersionCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeURIcore on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeURIoperation on EquipmentBoundaryVersion
   *
   * @param command AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeURIoperation(
      AssignEntsoeURIoperationToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign EntsoeURIoperation on EquipmentBoundaryVersion
   *
   * @param command UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeURIoperation(
      UnAssignEntsoeURIoperationFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeURIoperation on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ModelDescriptionURI on EquipmentBoundaryVersion
   *
   * @param command AssignModelDescriptionURIToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignModelDescriptionURI(
      AssignModelDescriptionURIToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ModelDescriptionURI on EquipmentBoundaryVersion
   *
   * @param command UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignModelDescriptionURI(
      UnAssignModelDescriptionURIFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ModelDescriptionURI on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceRDF on EquipmentBoundaryVersion
   *
   * @param command AssignNamespaceRDFToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceRDF(AssignNamespaceRDFToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NamespaceRDF on EquipmentBoundaryVersion
   *
   * @param command UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceRDF(UnAssignNamespaceRDFFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceRDF on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceUML on EquipmentBoundaryVersion
   *
   * @param command AssignNamespaceUMLToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceUML(AssignNamespaceUMLToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign NamespaceUML on EquipmentBoundaryVersion
   *
   * @param command UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceUML(UnAssignNamespaceUMLFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceUML on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortName on EquipmentBoundaryVersion
   *
   * @param command AssignShortNameToEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void assignShortName(AssignShortNameToEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getEquipmentBoundaryVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    EquipmentBoundaryVersionBusinessDelegate parentDelegate =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Throwable exc) {
      final String msg = "Failed to get StringProxy using id " + childId;
      LOGGER.log(Level.WARNING, msg);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * unAssign ShortName on EquipmentBoundaryVersion
   *
   * @param command UnAssignShortNameFromEquipmentBoundaryVersionCommand
   * @exception ProcessingException
   */
  public void unAssignShortName(UnAssignShortNameFromEquipmentBoundaryVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EquipmentBoundaryVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortName on EquipmentBoundaryVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return EquipmentBoundaryVersion
   */
  private EquipmentBoundaryVersion load(UUID id) throws ProcessingException {
    equipmentBoundaryVersion =
        EquipmentBoundaryVersionBusinessDelegate.getEquipmentBoundaryVersionInstance()
            .getEquipmentBoundaryVersion(new EquipmentBoundaryVersionFetchOneSummary(id));
    return equipmentBoundaryVersion;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private EquipmentBoundaryVersion equipmentBoundaryVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(EquipmentBoundaryVersionBusinessDelegate.class.getName());
}
