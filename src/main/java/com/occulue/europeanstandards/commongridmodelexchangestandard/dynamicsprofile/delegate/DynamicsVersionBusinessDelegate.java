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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.validator.*;
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
 * DynamicsVersion business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of DynamicsVersion related services in the case of a
 *       DynamicsVersion business related service failing.
 *   <li>Exposes a simpler, uniform DynamicsVersion interface to the business tier, making it easy
 *       for clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill DynamicsVersion business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DynamicsVersionBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DynamicsVersionBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * DynamicsVersion Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DynamicsVersionBusinessDelegate
   */
  public static DynamicsVersionBusinessDelegate getDynamicsVersionInstance() {
    return (new DynamicsVersionBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDynamicsVersion(CreateDynamicsVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDynamicsVersionId() == null) command.setDynamicsVersionId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDynamicsVersionCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDynamicsVersionCommand of DynamicsVersion is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create DynamicsVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDynamicsVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDynamicsVersion(UpdateDynamicsVersionCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDynamicsVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save DynamicsVersion - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDynamicsVersionCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDynamicsVersionCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDynamicsVersionCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete DynamicsVersion using Id = " + command.getDynamicsVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the DynamicsVersion via DynamicsVersionFetchOneSummary
   *
   * @param summary DynamicsVersionFetchOneSummary
   * @return DynamicsVersionFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public DynamicsVersion getDynamicsVersion(DynamicsVersionFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DynamicsVersionFetchOneSummary arg cannot be null");

    DynamicsVersion entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a DynamicsVersion
      // --------------------------------------
      CompletableFuture<DynamicsVersion> futureEntity =
          queryGateway.query(
              new FindDynamicsVersionQuery(
                  new LoadDynamicsVersionFilter(summary.getDynamicsVersionId())),
              ResponseTypes.instanceOf(DynamicsVersion.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg =
          "Unable to locate DynamicsVersion with id " + summary.getDynamicsVersionId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all DynamicsVersions
   *
   * @return List<DynamicsVersion>
   * @exception ProcessingException Thrown if any problems
   */
  public List<DynamicsVersion> getAllDynamicsVersion() throws ProcessingException {
    List<DynamicsVersion> list = null;

    try {
      CompletableFuture<List<DynamicsVersion>> futureList =
          queryGateway.query(
              new FindAllDynamicsVersionQuery(),
              ResponseTypes.multipleInstancesOf(DynamicsVersion.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all DynamicsVersion";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * assign BaseUML on DynamicsVersion
   *
   * @param command AssignBaseUMLToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseUML(AssignBaseUMLToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign BaseUML on DynamicsVersion
   *
   * @param command UnAssignBaseUMLFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseUML(UnAssignBaseUMLFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseUML on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign BaseURI on DynamicsVersion
   *
   * @param command AssignBaseURIToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignBaseURI(AssignBaseURIToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign BaseURI on DynamicsVersion
   *
   * @param command UnAssignBaseURIFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignBaseURI(UnAssignBaseURIFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign BaseURI on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign Date on DynamicsVersion
   *
   * @param command AssignDateToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignDate(AssignDateToDynamicsVersionCommand command) throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .DateProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .DateProxyBusinessDelegate.getDateProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getDateProxyId();
    DateProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign Date on DynamicsVersion
   *
   * @param command UnAssignDateFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDate(UnAssignDateFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign Date on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign DifferenceModelURI on DynamicsVersion
   *
   * @param command AssignDifferenceModelURIToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignDifferenceModelURI(AssignDifferenceModelURIToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign DifferenceModelURI on DynamicsVersion
   *
   * @param command UnAssignDifferenceModelURIFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignDifferenceModelURI(
      UnAssignDifferenceModelURIFromDynamicsVersionCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign DifferenceModelURI on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeUML on DynamicsVersion
   *
   * @param command AssignEntsoeUMLToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeUML(AssignEntsoeUMLToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign EntsoeUML on DynamicsVersion
   *
   * @param command UnAssignEntsoeUMLFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeUML(UnAssignEntsoeUMLFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeUML on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign EntsoeURI on DynamicsVersion
   *
   * @param command AssignEntsoeURIToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignEntsoeURI(AssignEntsoeURIToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign EntsoeURI on DynamicsVersion
   *
   * @param command UnAssignEntsoeURIFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignEntsoeURI(UnAssignEntsoeURIFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign EntsoeURI on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ModelDescriptionURI on DynamicsVersion
   *
   * @param command AssignModelDescriptionURIToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignModelDescriptionURI(AssignModelDescriptionURIToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign ModelDescriptionURI on DynamicsVersion
   *
   * @param command UnAssignModelDescriptionURIFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignModelDescriptionURI(
      UnAssignModelDescriptionURIFromDynamicsVersionCommand command) throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ModelDescriptionURI on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceRDF on DynamicsVersion
   *
   * @param command AssignNamespaceRDFToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceRDF(AssignNamespaceRDFToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign NamespaceRDF on DynamicsVersion
   *
   * @param command UnAssignNamespaceRDFFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceRDF(UnAssignNamespaceRDFFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceRDF on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign NamespaceUML on DynamicsVersion
   *
   * @param command AssignNamespaceUMLToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignNamespaceUML(AssignNamespaceUMLToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign NamespaceUML on DynamicsVersion
   *
   * @param command UnAssignNamespaceUMLFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignNamespaceUML(UnAssignNamespaceUMLFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign NamespaceUML on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * assign ShortName on DynamicsVersion
   *
   * @param command AssignShortNameToDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void assignShortName(AssignShortNameToDynamicsVersionCommand command)
      throws ProcessingException {

    // --------------------------------------------
    // load the parent
    // --------------------------------------------
    load(command.getDynamicsVersionId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
            .StringProxyBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.delegate
                .StringProxyBusinessDelegate.getStringProxyInstance();
    DynamicsVersionBusinessDelegate parentDelegate =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance();
    UUID childId = command.getAssignment().getStringProxyId();
    StringProxy child = null;

    try {
      // --------------------------------------
      // best to validate the command now
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

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
   * unAssign ShortName on DynamicsVersion
   *
   * @param command UnAssignShortNameFromDynamicsVersionCommand
   * @exception ProcessingException
   */
  public void unAssignShortName(UnAssignShortNameFromDynamicsVersionCommand command)
      throws ProcessingException {

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DynamicsVersionValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to unassign ShortName on DynamicsVersion";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return DynamicsVersion
   */
  private DynamicsVersion load(UUID id) throws ProcessingException {
    dynamicsVersion =
        DynamicsVersionBusinessDelegate.getDynamicsVersionInstance()
            .getDynamicsVersion(new DynamicsVersionFetchOneSummary(id));
    return dynamicsVersion;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private DynamicsVersion dynamicsVersion = null;
  private static final Logger LOGGER =
      Logger.getLogger(DynamicsVersionBusinessDelegate.class.getName());
}
